package io.github.jpmillz.allomanticawakening.events;

import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import io.github.jpmillz.allomanticawakening.abilities.Ability;
import io.github.jpmillz.allomanticawakening.abilities.AbilityHelper;
import io.github.jpmillz.allomanticawakening.abilities.AbilityRecords;
import io.github.jpmillz.allomanticawakening.components.ComponentRegister;
import io.github.jpmillz.allomanticawakening.items.ItemInit;
import io.github.jpmillz.allomanticawakening.items.tools.BrassSword;
import io.github.jpmillz.allomanticawakening.setup.registration.Registration;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

import java.awt.*;
import java.util.List;

@EventBusSubscriber(modid = AllomanticAwakening.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerOverlays(RegisterGuiLayersEvent event){
        event.registerAbove(VanillaGuiLayers.CROSSHAIR, ResourceLocation.fromNamespaceAndPath(AllomanticAwakening.MODID, "random"), new LayeredDraw.Layer() {
            @Override
            public void render(GuiGraphics pGuiGraphics, DeltaTracker pDeltaTracker) {
                Player player = Minecraft.getInstance().player;
                Item stack = player.getItemInHand(InteractionHand.MAIN_HAND).getItem();
                int height = pGuiGraphics.guiHeight();
                int width = pGuiGraphics.guiWidth();
                if (stack.equals(ItemInit.BRASS_SWORD.get())) {
                    List<AbilityRecords.AbilityData> abilities = player.getData(Registration.ABILITY_DATA).abilities();
                    pGuiGraphics.drawString(Minecraft.getInstance().font, Integer.toString(AbilityHelper.getCurrentCapacity(player,Ability.PEWTER)), width - 20, height- 10, Color.BLUE.getRGB());

                }

            }
        });
    }

    private static String getAbilitiesString(List<AbilityRecords.AbilityData> abilities){
        StringBuilder builder = new StringBuilder();
        for (AbilityRecords.AbilityData data : abilities){
            builder.append(data.ability().toString() + " " + data.currentCapacity() + " " + data.isEnabled() +" \n");
        }
        return builder.toString();
    }

}
