package io.github.jpmillz.allomanticawakening.events;

import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import io.github.jpmillz.allomanticawakening.items.ItemInit;
import io.github.jpmillz.allomanticawakening.items.datacomponents.ComponentRegister;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.CustomizeGuiOverlayEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

import java.util.HashMap;

@EventBusSubscriber(modid = AllomanticAwakening.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerOverlays(RegisterGuiLayersEvent event){
        event.registerAbove(VanillaGuiLayers.CROSSHAIR, ResourceLocation.fromNamespaceAndPath(AllomanticAwakening.MODID, "random"), new LayeredDraw.Layer() {
            @Override
            public void render(GuiGraphics pGuiGraphics, DeltaTracker pDeltaTracker) {
                Player player = Minecraft.getInstance().player;
                ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
                if (stack.is(Items.DIAMOND_SWORD)){
                    int hits = stack.getOrDefault(ComponentRegister.HITS_COMP, 0);
                    if (hits > 0){
                        pGuiGraphics.drawString(Minecraft.getInstance().font, "Hits: " + hits, 100, 100, 0xFFFFFF);
                    }
                }
            }


        });
    }

}
