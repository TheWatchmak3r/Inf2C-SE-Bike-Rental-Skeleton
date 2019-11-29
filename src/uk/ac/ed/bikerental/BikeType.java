package uk.ac.ed.bikerental;

import java.math.BigDecimal;
<<<<<<< HEAD
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

=======

//decided to implement as an enum for bike types
enum Type {
    MOUNTAIN("mountain bike"),
    ROAD("road bike"),
    HYBRID("hybrid bike"),
    EBIKE("electric bike");
	
    /* fields */
    private String typeName;
    
    /* constructor */
	Type(String typeName) {
		this.typeName = typeName;
	}
	
	/* accessors */
    public String getType() {return this.typeName;}
>>>>>>> 37c057210c65243aa7b5aed3d24d76ae1ee48783
}

public class BikeType {
	
    private Type bikeType;
    private BigDecimal replacementValue;
	
	/* constructor */
    public BikeType(String typeName, BigDecimal replacementValue) {
    	for (Type t : Type.values()) {
    		if (t.getType() == typeName.toLowerCase()) {
    			this.bikeType = t;
    			break;
    		}
    	}
        this.replacementValue = replacementValue;
    }
    
    public Type getBikeType() {
	return bikeType;
    }
	
    public BigDecimal getReplacementValue() {
        return this.replacementValue;
    }
}
