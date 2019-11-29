package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.Objects;

// decided to implement as an enum
public class BikeType {
    /* fields */
    BikeProvider bikeProvider;
    String typeName;
    BikeCategory bikeCategory;
    BigDecimal replacementValue;
    BigDecimal dailyRentalPrice;


    /* constructor */
    BikeType(BikeProvider bikeProvider, String typeName, BikeCategory bikeCategory,
             BigDecimal replacementValue, BigDecimal dailyRentalPrice) {
        this.bikeProvider = bikeProvider;
        this.typeName = typeName;
        this.bikeCategory = bikeCategory;
        this.replacementValue = replacementValue;
        this.dailyRentalPrice = dailyRentalPrice;
    }

    /* accessors */
    public BikeProvider getBikeProvider() {
        return bikeProvider;
    }

    public String getBikeType() {
        return this.typeName;
    }

    public BikeCategory getBikeCategory() {

        return bikeCategory;
    }

    public BigDecimal getReplacementValue() {

        return replacementValue;
    }

    public BigDecimal getDailyRentalPrice() {

        return dailyRentalPrice;
    }

    /* methods */
    public BigDecimal getDepositValue() {
        return bikeProvider.getDepositRate().multiply(replacementValue);
    }

}

