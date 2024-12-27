package io.github.jpmillz.allomanticawakening.capabilities;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.UnknownNullability;

public class MetalData implements INBTSerializable<CompoundTag> {

    private double metalReserves;
    private double maxReserves;
    private double minReserves;

    public MetalData(){
    }

    public void setReserves(double amount){
        this.metalReserves = amount;
    }

    public double getMetalReserves(){
        return this.metalReserves;
    }

    public void setMaxReserves(double amount){
        this.maxReserves = amount;
    }

    public double getMaxReserves(){
        return maxReserves;
    }

    public void setMinReserves(double amount){
        this.minReserves = amount;
    }

    public double getMinReserves(){
        return minReserves;
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
