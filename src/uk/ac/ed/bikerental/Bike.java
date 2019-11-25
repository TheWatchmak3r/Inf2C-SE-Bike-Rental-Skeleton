package uk.ac.ed.bikerental;

import java.math.BigDecimal;

public class Bike {
    /* fields */
    BikeType bikeType;

    /* constructor */
    Bike(BikeType bikeType) {
        this.bikeType = bikeType;
    }
    /* accessors */
    public BikeType getType() { return bikeType;}

    /* methods */
    public BigDecimal getDeposit(BigDecimal depositRate) {
        return depositRate.multiply(this.getType().getReplacementValue()
    }

}