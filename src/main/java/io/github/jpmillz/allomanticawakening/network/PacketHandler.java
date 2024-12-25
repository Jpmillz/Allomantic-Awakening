package io.github.jpmillz.allomanticawakening.network;

import io.github.jpmillz.allomanticawakening.AllomanticAwakening;
import io.github.jpmillz.allomanticawakening.network.handlers.AbilityDataHandler;
import io.github.jpmillz.allomanticawakening.network.payloads.AbilityDataPayload;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class PacketHandler {

    public static void register(final RegisterPayloadHandlersEvent event){
        final PayloadRegistrar registrar = event.registrar(AllomanticAwakening.MODID);
        registrar.playToClient(AbilityDataPayload.TYPE, AbilityDataPayload.STREAM_CODEC, AbilityDataHandler::handle);
    }
}
