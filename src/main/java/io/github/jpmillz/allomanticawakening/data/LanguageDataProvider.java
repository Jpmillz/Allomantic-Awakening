package io.github.jpmillz.allomanticawakening.data;

import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import io.github.jpmillz.allomanticawakening.items.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LanguageDataProvider extends LanguageProvider {

    public LanguageDataProvider(PackOutput output){
        super(output, AllomanticAwakening.MODID, "en_us");

    }

    @Override
    protected void addTranslations() {
        addItem(ItemInit.BRASS_INGOT, "Brass Ingot");
    }
}
