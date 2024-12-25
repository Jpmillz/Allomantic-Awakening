package io.github.jpmillz.allomanticawakening.events;

import io.github.jpmillz.allomanticawakening.abilities.AbilityRecords;
import io.github.jpmillz.allomanticawakening.components.ComponentRegister;
import io.github.jpmillz.allomanticawakening.network.payloads.AbilityDataPayload;
import io.github.jpmillz.allomanticawakening.setup.registration.Registration;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.PacketDistributor;



public class PlayerEvents {

    //move to a setup class
    @SubscribeEvent
    public void syncDataEvent(PlayerEvent.StartTracking event){
        Player player = event.getEntity();
        if (player instanceof ServerPlayer sPlayer){
            AbilityRecords.PlayerAbilityHolder holder = sPlayer.getData(Registration.ABILITY_DATA);
            PacketDistributor.sendToPlayer(sPlayer, new AbilityDataPayload(holder.abilities()));
        }
    }

    @SubscribeEvent
    public void randomEvent(AttackEntityEvent event){
        Player player = event.getEntity();
        ItemStack weapon = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (weapon.is(Items.DIAMOND_SWORD)){

        }
    }


    @SubscribeEvent
    public void modifyDamge(ItemAttributeModifierEvent event){
        ItemStack stack = event.getItemStack();
        int hits = stack.getOrDefault(ComponentRegister.HITS_COMP, 0);
        if (stack.is(Items.DIAMOND_SWORD) && (hits > 0) && (hits % 10 == 0)){
            event.replaceModifier(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID,  2, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
        }
    }
}
