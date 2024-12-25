package io.github.jpmillz.allomanticawakening.abilities;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.ArrayList;
import java.util.List;

public class AbilityRecords {

    public record AbilityData(Ability ability, int currentCapacity, boolean isEnabled){
        public static final Codec<AbilityData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Ability.CODEC.fieldOf("ability").forGetter(AbilityData::ability),
                Codec.INT.fieldOf("currentCapacity").forGetter(AbilityData::currentCapacity),
                Codec.BOOL.fieldOf("isEnabled").forGetter(AbilityData::isEnabled)
        ).apply(instance, AbilityData::new));

        public static final Codec<List<AbilityData>> LIST_CODEC = CODEC.listOf();

        public static final StreamCodec<FriendlyByteBuf, AbilityData> STREAM_CODEC = StreamCodec.composite(
                Ability.STREAM_CODEC, AbilityData::ability,
                ByteBufCodecs.VAR_INT, AbilityData::currentCapacity,
                ByteBufCodecs.BOOL, AbilityData::isEnabled,
                AbilityData::new);

        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            if (!(obj instanceof Ability)){
                return false;
            }
            Ability dataObj = (Ability) obj;
            if (dataObj.name().equals(this.ability().name())){
                return true;
            }
            return false;
        }
    }

    public record PlayerAbilityHolder(List<AbilityData> abilities){
        public static final Codec<PlayerAbilityHolder> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                AbilityData.LIST_CODEC.fieldOf("abilities").forGetter(PlayerAbilityHolder::abilities)
        ).apply(instance, PlayerAbilityHolder::new));

        //public static final StreamCodec<ByteBuf, PlayerAbilityHolder> STREAM_CODEC = ByteBufCodecs.fromCodec(CODEC);

        public static final StreamCodec<FriendlyByteBuf, List<AbilityData>> STREAM_CODEC = AbilityData.STREAM_CODEC.apply(ByteBufCodecs.list());
    }
}
