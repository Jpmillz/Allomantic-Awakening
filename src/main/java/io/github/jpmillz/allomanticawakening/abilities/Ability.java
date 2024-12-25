package io.github.jpmillz.allomanticawakening.abilities;

import com.mojang.serialization.Codec;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;

public enum Ability implements StringRepresentable {
    PEWTER("pewter_ability", 100),
    TIN("tin_ability", 100);

    private String name;
    private int maxCapacity;
    public static final Codec<Ability> CODEC = StringRepresentable.fromValues(Ability::values);
    public static final StreamCodec<FriendlyByteBuf, Ability> STREAM_CODEC = NeoForgeStreamCodecs.enumCodec(Ability.class);

    Ability(String name, int maxCapacity){
        this.name= name;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
