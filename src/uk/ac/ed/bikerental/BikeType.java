package uk.ac.ed.bikerental;

import java.math.BigDecimal;

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
