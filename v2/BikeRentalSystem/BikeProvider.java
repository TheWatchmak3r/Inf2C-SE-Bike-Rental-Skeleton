
import java.math.BigDecimal;
import java.net.BindException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class BikeProvider {
    /* fields */
    private String name;
    private Location location;
    private BigDecimal depositRate;
    private ArrayList<BikeProvider> partners;
    private ArrayList<BikeType> bikeTypes;
    private ArrayList<Bike> bikeStock;

    /* constructor */
    public BikeProvider(String name, Location location, BigDecimal depositRate) {
        this.name = name;
        this.location = location;
        this.depositRate = depositRate;
        this.partners = new ArrayList<BikeProvider>();
        this.bikeTypes = new ArrayList<BikeType>();
        this.bikeStock = new ArrayList<Bike>();
        SystemDatabase.addBikeProvider(this);
    }

    /* accessors */
    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public BigDecimal getDepositRate() { return depositRate; }

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
    	bikeStock.add(new Bike(bikeType));
    }

    public Order searchForQuote(DateRange dateRange, Location location,
                                ArrayList<BikeCategory> requestedBikeCategories, Boolean delivery) {
        HashSet<Bike> bikesAvailable = new HashSet<Bike>();
        for (Bike bike : bikeStock) {
            if (requestedBikeCategories.contains(bike.getBikeCategory()) && bike.checkDateRange(dateRange)) {
                bikesAvailable.add(bike);
                if (bikesAvailable.size() == requestedBikeCategories.size()) {
                    Order quote =  new Order(this, dateRange, location, bikesAvailable, delivery);
                    return quote;
                }
            }
        }
        return null;
    }

    public void bookOrder(Order order) {
        order.book();
    }

    public void checkoutBikes(String bookingID) {
        SystemDatabase.orders.get(bookingID).takeBikes();
    }

    public void returnBikes(Order order) {
        order.returnBikes(location);
    }
}
