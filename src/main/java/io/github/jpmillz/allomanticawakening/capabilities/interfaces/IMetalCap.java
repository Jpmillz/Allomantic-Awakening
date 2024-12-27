package io.github.jpmillz.allomanticawakening.capabilities.interfaces;

public interface IMetalCap {

    void setReserves(double amount);

    double getReserves();

    void setMaxReserves(double maxAmount);

    double getMaxReserves();

    void setMinReserves(double minAmount);

    double getMinReserves();

    boolean removeReserves(double amountToRemove);

}
