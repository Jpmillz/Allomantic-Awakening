package io.github.jpmillz.allomanticawakening.events;

import io.github.jpmillz.allomanticawakening.items.ItemInit;
import io.github.jpmillz.allomanticawakening.items.TestItem;
import io.github.jpmillz.allomanticawakening.items.datacomponents.ComponentRegister;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;



public class PlayerEvents {

    @SubscribeEvent
    public void randomEvent(AttackEntityEvent event){
        Player player = event.getEntity();
        ItemStack weapon = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (weapon.is(Items.DIAMOND_SWORD)){
            int hits = weapon.getOrDefault(ComponentRegister.HITS_COMP, 0);
            System.out.println(hits);
            int modifiedHits = hits += 1;
            weapon.set(ComponentRegister.HITS_COMP, modifiedHits);
            double damage = weapon.getAttributeModifiers().modifiers().stream().filter(v -> v.attribute().equals(Attributes.ATTACK_DAMAGE)).map(v -> v.modifier().amount()).findFirst().get();
            System.out.println(damage);

        }

    }


    @SubscribeEvent
    public void modifyDamge(ItemAttributeModifierEvent event){
        ItemStack stack = event.getItemStack();
        int hits = stack.getOrDefault(ComponentRegister.HITS_COMP, 0);
        if (stack.is(Items.DIAMOND_SWORD) && (hits > 0) && (hits % 10 == 0)){
            event.replaceModifier(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, damage + 2, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
        }
    }
}
