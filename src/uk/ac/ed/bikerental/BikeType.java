package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.Objects;

public class BikeType {

    MOUNTAIN("Mountain bike"),
    ROAD("Road bike"),
    HYBRID("Hybrid bike");

    /* fields */
    private String typeName;
    private BigDecimal replacmentValue


    /* constructor */
    public BikeType(String typeName, BigDecimal replacmentValue) {
        this.typeName = typeName;
        this.replacmentValue = replacmentValue;
    }

    /* accessors */
    public String getTypeName() {
        return this.typeName;

    }

    /* methods */
    public BigDecimal getReplacementValue() { return repacementValue}
}