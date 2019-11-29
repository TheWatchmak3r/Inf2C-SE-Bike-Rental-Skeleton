
import java.math.BigDecimal;

public class BikeType {
    /* fields */
    private BikeProvider bikeProvider;
    private String typeName;
    private BikeCategory bikeCategory;
    private BigDecimal replacementValue;
    private BigDecimal dailyRentalPrice;


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
        return typeName;
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
    // TODO (last) change deposit value to a field
    public BigDecimal getDepositValue() {
        return bikeProvider.getDepositRate().multiply(replacementValue);
    }
}