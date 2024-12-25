package io.github.jpmillz.allomanticawakening.abilities;

import io.github.jpmillz.allomanticawakening.setup.registration.Registration;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class AbilityHelper {

    public static int getCurrentCapacity(Player player, Ability ability){
        List<AbilityRecords.AbilityData> dataList = getAbilityData(player);
        if (abilityUnlockCheck(player, ability)){
            int currentCapacity = dataList.stream()
                    .filter(v -> v.ability().equals(ability))
                    .mapToInt(AbilityRecords.AbilityData::currentCapacity)
                    .findFirst()
                    .getAsInt();
            return currentCapacity;
        }
        return -1;
    }

    public static boolean setEnabled(Player player, Ability ability){
        List<AbilityRecords.AbilityData> oldData = getAbilityData(player);
        List<AbilityRecords.AbilityData> newData = new ArrayList<>();
        if (abilityUnlockCheck(player, ability)){
            for (AbilityRecords.AbilityData data : oldData){
                Ability currentAbility = data.ability();
                int currentCap = getCurrentCapacity(player, ability);
                if (data.ability().equals(ability)){
                    newData.add(new AbilityRecords.AbilityData(currentAbility, currentCap, true));
                }else {
                    newData.add(new AbilityRecords.AbilityData(currentAbility, currentCap, data.isEnabled()));
                }
            }
            player.setData(Registration.ABILITY_DATA, new AbilityRecords.PlayerAbilityHolder(newData));
            return true;
        }
        return false;
    }

    public static List<AbilityRecords.AbilityData> getAbilityData(Player player){
        return player.getData(Registration.ABILITY_DATA).abilities();
    }

    public static boolean abilityUnlockCheck(Player player, Ability ability){
       List<AbilityRecords.AbilityData> dataList = getAbilityData(player);
       boolean hasAbility = dataList.stream().anyMatch(v -> v.ability().equals(ability));
       return !dataList.isEmpty() && hasAbility;

    }

    public static boolean hasAbilityData(Player player){
        return player.hasData(Registration.ABILITY_DATA);
    }
}
