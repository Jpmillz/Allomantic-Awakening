package io.github.jpmillz.allomanticawakening.attachments;

import com.mojang.serialization.Codec;
import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class AttachmentRegister {

    public static DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPE = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, AllomanticAwakening.MODID);

}
