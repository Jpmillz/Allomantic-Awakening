package io.github.jpmillz.allomanticawakening.components;

import com.mojang.serialization.Codec;
import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ComponentRegister {

    public static final DeferredRegister.DataComponents MOD_COMPONENTS = DeferredRegister.createDataComponents(AllomanticAwakening.MODID);

    public static final Supplier<DataComponentType<Integer>> HITS_COMP = MOD_COMPONENTS.registerComponentType("hits",
            (integerBuilder -> integerBuilder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT)));
}
