package io.github.jpmillz.allomanticawakening.capabilities;

import io.github.jpmillz.allomanticawakening.capabilities.interfaces.IMetalCap;
import io.github.jpmillz.allomanticawakening.setup.registration.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.UnknownNullability;

import java.rmi.registry.Registry;

public class MetalCapability implements IMetalCap, INBTSerializable<CompoundTag> {
    
    private double metalReserves;
    private double maxReserves;
    private double minReserves;
    private MetalData metalData;

    public MetalCapability(LivingEntity entity){
        metalData = entity.getData(Registration.METAL_DATA);
    }

    @Override
    public void setReserves(double amount) {
        if (amount > 0){
            this.metalReserves = Math.min(amount, maxReserves);
        }
    }

    @Override
    public double getReserves() {
        return this.metalReserves;
    }

    @Override
    public void setMaxReserves(double maxAmount) {
        this.maxReserves = maxAmount;
    }

    @Override
    public double getMaxReserves() {
        return maxReserves;
    }

    @Override
    public void setMinReserves(double minAmount) {
        if (minAmount < 0){
            this.minReserves = 0;
        }else {
            minReserves = minAmount;
        }
    }

    @Override
    public double getMinReserves() {
        return minReserves;
    }

    @Override
    public boolean removeReserves(double amountToRemove) {
        if (amountToRemove > 0){
            double newAmount = this.metalReserves - amountToRemove;
            this.metalReserves = Math.max(0, newAmount);
            return true;
        }
        return false;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        tag.putDouble("metal_reserves", metalReserves);
        tag.putDouble("max_reserves", maxReserves);
        tag.putDouble("min_reserves", minReserves);
        return tag;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag tag) {
        setReserves(tag.getDouble("metal_reserves"));
        setMaxReserves(tag.getDouble("max_reserves"));
        setMinReserves(tag.getDouble("min_reserves"));
    }
}
