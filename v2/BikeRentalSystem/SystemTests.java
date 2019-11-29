
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
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
	BikeProvider provider1 = new BikeProvider("John", new Location("EH3 9LJ", "university"), "1234567890");
	BikeType type1 = new BikeType("mountain bike", new BigDecimal(100));
	Bike bike1 = new Bike(type1, provider1);
	Bike bike2 = new Bike(type1, provider1);
	

    @BeforeEach
    void setUp() throws Exception {
        // Setup mock delivery service before each tests
        DeliveryServiceFactory.setupMockDeliveryService();
        
        // Put your test setup here
        
    }

    @Test
    void testGetQuote() {
        
    }
    
    @Test
    void testbookQuote() {
        
    }
    
    @Test
    void testReturnBikes() {
        
    }
    
}
