package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.Objects;

public enum BikeCategory {
    MOUNTAIN("Mountain bike"),
    ROAD("Road bike"),
    HYBRID("Hybrid bike"),
    EBIKE("Electric bike");

    /* fields */
    private String categoryName;

    /* constructor */
    BikeCategory(String categoryName) {
        this.categoryName = typeName;
    }

    /* accessors */
    public String getBikeCategory() {
        return this.categoryName;
    }

    /* methods */

}