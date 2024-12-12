package io.github.jpmillz.allomanticawakening;

import io.github.jpmillz.allomanticawakening.events.ClientEvents;
import io.github.jpmillz.allomanticawakening.events.PlayerEvents;
import io.github.jpmillz.allomanticawakening.items.ItemInit;
import io.github.jpmillz.allomanticawakening.items.datacomponents.ComponentRegister;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(AllomanticAwakening.MODID)
public class AllomanticAwakening {

    public static final String MODID = "allomanticawakening";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AllomanticAwakening(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        ItemInit.ITEMS.register(modEventBus);
        ComponentRegister.MOD_COMPONENTS.register(modEventBus);

        NeoForge.EVENT_BUS.register(new PlayerEvents());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
