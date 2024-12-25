package io.github.jpmillz.allomanticawakening.items;


import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import io.github.jpmillz.allomanticawakening.items.tools.BrassSword;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, AllomanticAwakening.MODID);

    public static final DeferredHolder<Item, Item> BRASS_INGOT = ITEMS.register("brass_ingot", ()-> new Item(new Item.Properties()));

    public static final Supplier<SwordItem> BRASS_SWORD = ITEMS.register("brass_sword", ()->new BrassSword(Tiers.DIAMOND, new Item.Properties()));
}
