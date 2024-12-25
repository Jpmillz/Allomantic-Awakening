package io.github.jpmillz.allomanticawakening.network.handlers;

import io.github.jpmillz.allomanticawakening.abilities.AbilityRecords;
import io.github.jpmillz.allomanticawakening.network.payloads.AbilityDataPayload;
import io.github.jpmillz.allomanticawakening.setup.registration.Registration;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class AbilityDataHandler {


    public static void handle(final AbilityDataPayload data, IPayloadContext context) {
        context.enqueueWork(()->{
            Player player = context.player();
            player.setData(Registration.ABILITY_DATA, new AbilityRecords.PlayerAbilityHolder(data.abilities()));
        });
    }

}
