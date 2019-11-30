
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class SystemTests {
    // You can add attributes here
	private BikeProvider provider1, provider2, provider3;
	private BikeType type1, type2, type3, type4, type5, type6, type7, type8;
	private Bike bike1, bike2, bike3, bike4, bike5, bike6, bike7, bike8, bike9, bike10, bike11, bike12;
	private DateRange dateRange1, dateRange2, dateRange3;
	private Location location1, location2, location3, location4;
	private EntryPoint search1, search2, search3, search4, search5;
	private BikeCategory mountain = BikeCategory.MOUNTAIN;
	private BikeCategory ebike = BikeCategory.EBIKE;
	private BikeCategory road = BikeCategory.ROAD;
	private BikeCategory hybrid = BikeCategory.HYBRID;
	private ArrayList<Order> quotes1, quotes2, quotes3, quotes4, quotes5;
	private Customer customer1, customer2, customer3;
	private Order order1, order2, order3;

    @BeforeEach
    void setUp() throws Exception {
        // Setup mock delivery service before each tests
        DeliveryServiceFactory.setupMockDeliveryService();
        
        // initializations of needed objects for testing
        this.location1 = new Location("EH1 1DB", "this is a street");
    	this.location2 = new Location("AB10 1DB", "some street in Aberdeen");
    	this.location3 = new Location("IV2 3EG", "address of Inverness castle");
    	this.location4 = new Location("EH8 9LJ", "30 George Square");
        provider1 = new BikeProvider("John", location1, new BigDecimal(0.2));
    	provider2 = new BikeProvider("Steve", location4, new BigDecimal(0.15));
    	provider3 = new BikeProvider("Chris", location2, new BigDecimal(0.25));
    	type1 = new BikeType(provider1, "mountain bike", mountain, new BigDecimal(100), new BigDecimal(20));
    	type2 = new BikeType(provider1, "electric bike", ebike, new BigDecimal(200), new BigDecimal(30));
    	type3 = new BikeType(provider1, "road bike", road, new BigDecimal(80), new BigDecimal(15));
    	type4 = new BikeType(provider1, "hybrid bike", hybrid, new BigDecimal(120), new BigDecimal(25));
    	type5 = new BikeType(provider2, "mountain bike", mountain, new BigDecimal(100), new BigDecimal(18));
    	type6 = new BikeType(provider2, "hybrid bike", hybrid, new BigDecimal(110), new BigDecimal(25));
    	type7 = new BikeType(provider2, "road bike", road, new BigDecimal(85), new BigDecimal(16));
    	type8 = new BikeType(provider3, "road bike", road, new BigDecimal(90), new BigDecimal(20));
    	// bikes of provider1
    	bike1 = new Bike(type1);
        bike2 = new Bike(type1);
    	bike3 = new Bike(type2);
    	bike4 = new Bike(type3);
    	bike5 = new Bike(type4);
    	// bikes of provider2
    	bike6 = new Bike(type5);
    	bike7 = new Bike(type6);
    	bike8 = new Bike(type7);
    	// bikes of provider3
    	bike10 = new Bike(type8);
    	bike11 = new Bike(type8);
    	bike12 = new Bike(type8);
    	// dateRange3 overlaps with dateRange1
    	this.dateRange1 = new DateRange(LocalDate.of(2019, 12, 7), LocalDate.of(2019, 12, 10));
        this.dateRange2 = new DateRange(LocalDate.of(2020, 1, 5), LocalDate.of(2020, 1, 23));
        this.dateRange3 = new DateRange(LocalDate.of(2019, 12, 8), LocalDate.of(2019, 12, 9));
        
        BikeCategory[] wantedBikes1 = {mountain, mountain, ebike, road};
        BikeCategory[] wantedBikes2 = {road, road, road};
        BikeCategory[] wantedBikes3 = {road, hybrid, mountain};
        this.search1 = new EntryPoint();
        this.search2 = new EntryPoint();
        this.search3 = new EntryPoint();
        this.search4 = new EntryPoint();
        this.search5 = new EntryPoint();
        quotes1 = search1.requestQuote(dateRange1, location1, new ArrayList<BikeCategory>(Arrays.asList(wantedBikes1)), true);
        quotes2 = search2.requestQuote(dateRange2, location2, new ArrayList<BikeCategory>(Arrays.asList(wantedBikes2)), false);
        quotes3 = search3.requestQuote(dateRange2, location4, new ArrayList<BikeCategory>(Arrays.asList(wantedBikes3)), false);
        quotes4 = search4.requestQuote(dateRange1, location3, new ArrayList<BikeCategory>(Arrays.asList(wantedBikes1)), false);
        
        customer1 = new Customer("Bob", "J", location1); // Order?
        customer2 = new Customer("Thea", "D", location2);
        customer3 = new Customer("Mary", "K", location4);
        
    }

    @Test
    void testGetQuoteValid() {
        // check quote list exclude bikes already booked
    	// quotes5 contains 1 result from provider1 for now
    	BikeCategory[] wantedBikes1 = {mountain, mountain, ebike, road};
    	quotes5 = search5.requestQuote(dateRange3, location4, new ArrayList<BikeCategory>(Arrays.asList(wantedBikes1)), false);
    	// quotes5 has requested dates dateRange3 at location4, which overlaps with
    	// dateRange1, therefore no available quote found when satisfying bikes are 
    	// reserved by quotes1
    	quotes5 = search5.requestQuote(dateRange3, location4, new ArrayList<BikeCategory>(Arrays.asList(wantedBikes1)), false);
    	assertNull(quotes5);
    }
    
    @Test
    void testGetQuoteLocation() {
    	// only providers near the customer provide quotes
    	// for quotes in quotes1, the location of the customer is location1 –– the provider should be provider1
    	for (Order quote : quotes1) {
    		assertTrue(quote.getBikeProvider().getLocation().isNearTo(location1));
    	}
    	// for quotes in quotes2, the location of the customer is location2 –– provider is provider2
    	for (Order quote : quotes2) {
    		assertTrue(quote.getBikeProvider().getLocation().isNearTo(location2));
    	}
    	// for quotes in quotes3, the location of the customer is location4 –– provider is also provider1
    	for (Order quote : quotes3) {
    		assertTrue(quote.getBikeProvider().getLocation().isNearTo(location4));
    	}
    }
    
    @Test
    void testGetQuoteResult() {
    	// the quote list includes all possible options with correct bikes and provider 
    	// quotes1, quotes2 should each return a singleton ArrayList of one quote found
    	assertEquals(1, quotes1.size());
    	assertEquals(4, quotes1.get(0).getBikes().size());
    	assertEquals(provider1, quotes1.get(0).getBikeProvider());
    	assertEquals(1, quotes2.size());
    	assertEquals(3, quotes2.get(0).getBikes().size());
    	assertEquals(provider1, quotes2.get(0).getBikeProvider());
    	// quotes3 should return 2 quotes, from provider1 and provider2
    	assertEquals(2, quotes3.size());
    	assertEquals(3, quotes3.get(0).getBikes().size());
    	assertEquals(provider1, quotes3.get(0).getBikeProvider());
    	assertEquals(3, quotes3.get(1).getBikes().size());
    	assertEquals(provider2, quotes3.get(1).getBikeProvider());
    	// quotes4 should return null (no provider in that location yet)
    	assertNull(quotes4);
    }
    
    @Test
    void testGetQuotePrice() {
        // check that the price calculated is correct based on provider-set price and the duration
    	// quotes1 –– (20*2 + 30 + 15) * 3 days = 255
    	assertEquals(new BigDecimal(255).setScale(2, RoundingMode.FLOOR), 
    			quotes1.get(0).getPrice().setScale(2, RoundingMode.FLOOR));
        // quotes2 –– (20 * 3) * 18 days = 1080
    	assertEquals(new BigDecimal(1080).setScale(2, RoundingMode.FLOOR), 
    			quotes2.get(0).getPrice().setScale(2, RoundingMode.FLOOR));
    	// quotes3 - first one – (20 + 15 + 25) * 18 days = 1080
    	assertEquals(new BigDecimal(1080).setScale(2, RoundingMode.FLOOR), 
    			quotes3.get(0).getPrice().setScale(2, RoundingMode.FLOOR));
    	// quotes3 - second one - (18 + 16 + 25) * 18 days = 1062
    	assertEquals(new BigDecimal(1062).setScale(2, RoundingMode.FLOOR), 
    	    	quotes3.get(2).getPrice().setScale(2, RoundingMode.FLOOR));
    }
    
    @Test
    void testGetQuoteDeposit() {
        // check that the deposit calculated is correct based on provider-set rate and replacement value
    	// quotes1 –– 0.2 * (100 * 2 + 200 + 80) = 96
    	assertEquals(new BigDecimal(96).setScale(2, RoundingMode.FLOOR), 
    			quotes1.get(0).getDeposit().setScale(2, RoundingMode.FLOOR));
        // quotes2 –– 0.25 * (90 * 3) = 67.5
    	assertEquals(new BigDecimal(67.5).setScale(2, RoundingMode.FLOOR), 
    			quotes2.get(0).getDeposit().setScale(2, RoundingMode.FLOOR));
    	// quotes3 - first one – 0.2 * (100 + 100 + 80) = 56
    	assertEquals(new BigDecimal(56).setScale(2, RoundingMode.FLOOR), 
    			quotes3.get(0).getDeposit().setScale(2, RoundingMode.FLOOR));
    	// quotes3 - second one - 0.15 * (100 + 110 + 85) = 44.25
    	assertEquals(new BigDecimal(44.25).setScale(2, RoundingMode.CEILING), 
    			quotes3.get(1).getDeposit().setScale(2, RoundingMode.CEILING));
    }
    
    @Test
    void testBookQuoteDetails() {
        // returns correct details of booking; check status is correct as well
    	// for instance, if customer1 wants to book the second quote from quotes3
    	// make a deep copy to store details of quote before it's booked
    	Order beforeBooking = new Order(quotes3.get(1).getBikeProvider(), quotes3.get(1).getDateRange(), quotes3.get(1).getLocation(), 
    			quotes3.get(1).getBikes(), quotes3.get(1).isDelivery());
    	assertEquals(quotes3.get(1).status, OrderStatus.QUOTED);
    	Order afterBooking = quotes3.get(1).book(customer3);         // make book() return itself (this
    	assertEquals(afterBooking, OrderStatus.BOOKED);
    	assertEquals(beforeBooking.getDateRange(), afterBooking.getDateRange());
    	assertEquals(beforeBooking.getBikes(), afterBooking.getBikes());
    	assertEquals(beforeBooking.isDelivery(), afterBooking.isDelivery());
    	// save booking for later tests
    	order2 = afterBooking;
    }
    
    @Test
    void testBookQuoteID() {
    	// booking number is unique
        order1 = quotes1.get(0).book(customer1);
        assertFalse(order1.getId().equals(order2.getId()));
        // it's very complicated for us to check that this ID is unique in all cases
        // and it's impossible to say this by simply enumerating a small number of orders
        // so this can be left for future implementation
    }
    
    @Test
    void testBookQuoteDelivery() {
    	// check delivery service is functional, check states are updated correctly
    	// because customer3 would like to use delivery service, order2 should be scheduled for delivery
    	assertTrue(order2.isDelivery());
    	// implemented mock delivery inside order class
    	order2.takeBikes();
    	assertEquals(BikeStatus.ON_DELIVERY, bike6.bikeStatus);
    	assertEquals(BikeStatus.ON_DELIVERY, bike7.bikeStatus);
    	assertEquals(BikeStatus.ON_DELIVERY, bike8.bikeStatus);
    }
    
    @Test
    void testReturnBikesOriginal() {
    	// accept booking number to handle return, check states are updated correctly
    	// first prepare for testing return (check bikes out first then return them)
        System.out.println(order1.getId());
    	provider1.checkoutBikes(order1.getId());
        order3 = quotes2.get(0).book(customer2);
        provider3.checkoutBikes(order3.getId());
        // orders 1 and 3 are returned to their original providers
    	provider1.returnBikes(order1.getId());
    	provider3.returnBikes(order3.getId());
    	// now check status of orders and bikes
    	assertEquals(OrderStatus.COMPLETE, order1.status);
    	assertEquals(BikeStatus.AVAILABLE, bike1.bikeStatus);
    	assertEquals(BikeStatus.AVAILABLE, bike2.bikeStatus);
    	assertEquals(BikeStatus.AVAILABLE, bike3.bikeStatus);
    	assertEquals(BikeStatus.AVAILABLE, bike4.bikeStatus);
    	assertEquals(OrderStatus.COMPLETE, order3.status);
    	assertEquals(BikeStatus.AVAILABLE, bike10.bikeStatus);
    	assertEquals(BikeStatus.AVAILABLE, bike11.bikeStatus);
    	assertEquals(BikeStatus.AVAILABLE, bike12.bikeStatus);
    }
    
    @Test
    void testReturnBikesPartner() {
        // delivery service should be used if returned to partner, also check state update
    	provider2.checkoutBikes(order2.getId());
    	provider2.makePartner(provider1);
    	// order2 is recorded return by provider1, a partner provider of provider2
    	provider1.returnBikes(order2.getId());
    	assertEquals(OrderStatus.COMPLETE, order2.status);
    	assertEquals(BikeStatus.ON_DELIVERY, bike6.bikeStatus);
    	assertEquals(BikeStatus.ON_DELIVERY, bike7.bikeStatus);
    	assertEquals(BikeStatus.ON_DELIVERY, bike8.bikeStatus);
    	// this is when provider2 receives the returned bikes
    	provider2.returnBikes(order2.getId());
    	assertEquals(BikeStatus.AVAILABLE, bike6.bikeStatus);
    	assertEquals(BikeStatus.AVAILABLE, bike7.bikeStatus);
    	assertEquals(BikeStatus.AVAILABLE, bike8.bikeStatus);
    }
    
}
