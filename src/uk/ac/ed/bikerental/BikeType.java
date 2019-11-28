package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.Objects;

// decided to implement as an enum
public enum BikeType {

    MOUNTAIN("Mountain bike"),
    ROAD("Road bike"),
    HYBRID("Hybrid bike"),
    EBIKE("Electric bike");

    /* fields */
    private String typeName;

    /* constructor */
    BikeType(String typeName) {
        this.typeName = typeName;
    }

    /* accessors */
    public String getBikeType() {return this.typeName;}

    /* methods */

}

