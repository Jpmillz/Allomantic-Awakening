package io.github.jpmillz.allomanticawakening.network.payloads;

import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import io.github.jpmillz.allomanticawakening.abilities.Ability;
import io.github.jpmillz.allomanticawakening.abilities.AbilityRecords;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public record AbilityDataPayload(List<AbilityRecords.AbilityData> abilities) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<AbilityDataPayload> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(AllomanticAwakening.MODID, "ability_sync"));

    public static final StreamCodec<FriendlyByteBuf, AbilityDataPayload> STREAM_CODEC = StreamCodec.composite(
            AbilityRecords.PlayerAbilityHolder.STREAM_CODEC,
            AbilityDataPayload::abilities,
            AbilityDataPayload::new);
    
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
