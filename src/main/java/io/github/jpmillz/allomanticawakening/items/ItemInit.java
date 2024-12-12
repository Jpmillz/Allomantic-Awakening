package io.github.jpmillz.allomanticawakening.items;


import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, AllomanticAwakening.MODID);

    public static final DeferredHolder<Item, Item> BRASS_INGOT = ITEMS.register("brass_ingot", ()-> new Item(new Item.Properties()));
}
