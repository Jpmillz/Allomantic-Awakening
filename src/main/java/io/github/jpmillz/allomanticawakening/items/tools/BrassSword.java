package io.github.jpmillz.allomanticawakening.items.tools;

import io.github.jpmillz.allomanticawakening.abilities.Ability;
import io.github.jpmillz.allomanticawakening.abilities.AbilityHelper;
import io.github.jpmillz.allomanticawakening.setup.registration.Registration;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;


public class BrassSword extends SwordItem {
    public BrassSword(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        return super.getDefaultAttributeModifiers(stack);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player pPlayer = pContext.getPlayer();
        Block block = pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock();
        if (block.equals(Blocks.GRASS_BLOCK)) {
            AbilityHelper.setEnabled(pPlayer, Ability.PEWTER);
            if (pContext.getLevel().isClientSide()){
                System.out.println("Client: " + pPlayer.getData(Registration.ABILITY_DATA));
            } else {
                System.out.println("Server: " + pPlayer.getData(Registration.ABILITY_DATA) );
            }

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

}
