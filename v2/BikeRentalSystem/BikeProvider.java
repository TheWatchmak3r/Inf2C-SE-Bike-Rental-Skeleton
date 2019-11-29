
import java.math.BigDecimal;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Map;

public class BikeProvider {
    /* fields */
    private String name;
    private Location location;
    private double depositRate;
    private ArrayList<BikeProvider> partners;
    private ArrayList<BikeType> bikeTypes;
    private ArrayList<Bike> bikeStock;

    /* constructor */
    public BikeProvider(String name, Location location, double depositRate) {
        this.name = name;
        this.location = location;
        this.depositRate = depositRate;
        this.partners = new ArrayList<BikeProvider>();
        this.bikeTypes = new ArrayList<BikeType>();
        this.bikeStock = new ArrayList<Bike>();  
    }

    /* accessors */
    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public BigDecimal getDepositRate() {
        return new BigDecimal(depositRate);
    }

    public boolean isPartnerWith(BikeProvider other) {
        return partners.contains(other);
    }

    public ArrayList<BikeType> getBikeTypes() {
        return bikeTypes;
    }

    public ArrayList<Bike> getBikeStock() {
        return bikeStock;
    }

    /* methods */
    public void addBikeType(String typeName, BikeCategory bikeCategory,
                             BigDecimal replacementValue, BigDecimal dailyRentalPrice) {
        this.bikeTypes.add(new BikeType(this, typeName, bikeCategory,
        		replacementValue, dailyRentalPrice));
    }

    public void addBike(BikeType bikeType) {
        // TODO (last) change to map implementation so can be called with name string
    	bikeStock.add(new Bike(bikeType));
    }

    public Order searchQuote(QuoteRequest quoteRequest) {
        //TODO write method checking if provider can fufill quote and adding quote to quote request if so
        return null;
    }

    public void bookOrder(Order order) {
        order.book();
    }

    public void checkoutBikes(Order order) {
        order.takeBikes();
    }

    public void returnBikes(Order order) {
        order.returnBikes();
    }
}
