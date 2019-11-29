
import java.math.BigDecimal;
import java.net.BindException;
import java.util.ArrayList;
import java.util.HashMap;
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
    private Map<String,Order> orders;

    /* constructor */
    public BikeProvider(String name, Location location, BigDecimal depositRate) {
        this.name = name;
        this.location = location;
        this.depositRate = depositRate;
        this.partners = new ArrayList<BikeProvider>();
        this.bikeTypes = new ArrayList<BikeType>();
        this.bikeStock = new ArrayList<Bike>();
        this.orders = new HashMap<String,Order>();
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

    private ArrayList<BikeType> getBikeTypes() {
        return bikeTypes;
    }

    private ArrayList<Bike> getBikeStock() {
        return bikeStock;
    }

    private Map<String,Order> getOrders() {
        return orders;
    }

    /* methods */
    public void addPartner(BikeProvider partnerBikeProvider) {
        partners.add(partnerBikeProvider);
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    private void addBikeType(String typeName, BikeCategory bikeCategory,
                             BigDecimal replacementValue, BigDecimal dailyRentalPrice) {
        this.bikeTypes.add(new BikeType(this, typeName, bikeCategory,
        		replacementValue, dailyRentalPrice));
    }

    private void addBike(BikeType bikeType) {
    	bikeStock.add(new Bike(bikeType));
    }

    // called by entryPoint requestQuote()
    // checks if provider has specified bikes on required dates in the local area
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
        orders.get(bookingID).takeBikes();
    }

    public void returnBikes(Order order) {
        order.returnBikes(location);
    }
}
