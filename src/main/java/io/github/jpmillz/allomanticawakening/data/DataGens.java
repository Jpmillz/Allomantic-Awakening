package io.github.jpmillz.allomanticawakening.data;

import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = AllomanticAwakening.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGens {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        PackOutput output = generator.getPackOutput();

        generator.addProvider(event.includeClient(), new LanguageDataProvider(output));
        generator.addProvider(event.includeClient(), new ItemModelDataProvider(output, helper));
    }
}
