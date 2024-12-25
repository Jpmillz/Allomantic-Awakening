package io.github.jpmillz.allomanticawakening.setup.registration;

import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import io.github.jpmillz.allomanticawakening.abilities.AbilityRecords;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.ArrayList;
import java.util.function.Supplier;

public class Registration {

    public static final DeferredRegister<AttachmentType<?>> ALLOMANTIC_ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, AllomanticAwakening.MODID);

    public static final Supplier<AttachmentType<AbilityRecords.PlayerAbilityHolder>> ABILITY_DATA = ALLOMANTIC_ATTACHMENTS.register(
            "ability_data",
            ()-> AttachmentType.builder(()-> new AbilityRecords.PlayerAbilityHolder(new ArrayList<>())).serialize(AbilityRecords.PlayerAbilityHolder.CODEC).copyOnDeath().build()
    );
}
