package io.github.jpmillz.allomanticawakening.data;

import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import io.github.jpmillz.allomanticawakening.items.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelDataProvider extends ItemModelProvider {

    public ItemModelDataProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AllomanticAwakening.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ItemInit.BRASS_INGOT.get());
    }
}
