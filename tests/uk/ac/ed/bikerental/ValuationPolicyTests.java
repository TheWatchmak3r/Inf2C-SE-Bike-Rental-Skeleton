
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.*;

public class ValuationPolicyTests {
    // You can add attributes here
    private BigDecimal deposit1, deposit2;
    private LinearDepreciation policy1;
    private DoubleDecBalanceDepreciation policy2;
    private BikeProvider provider1;
    private BikeType type1;
    private Bike bike1;
	
    @BeforeEach
    void setUp() throws Exception {
        // Put setup here
    	this.policy1 = new LinearDepreciation(0.1, 2016);
		this.policy2 = new DoubleDecBalanceDepreciation(0.1, 2016);
		
		// a mountain bike with replacement value 900 and rental price 50 per day provided by provider1
		this.provider1 = new BikeProvider("XX", 
				new Location("EHXXXX", "address"), new BigDecimal(0.2));
		this.type1 = new BikeType(provider1, "moutain bike", 
				BikeCategory.MOUNTAIN, new BigDecimal(900), new BigDecimal(50));
		this.bike1 = new Bike(type1);
		
		this.deposit1 = policy1.calculateValue(bike1, LocalDate.now());
		this.deposit1 = this.deposit1.setScale(2, RoundingMode.FLOOR);
		
		this.deposit2 = policy2.calculateValue(bike1, LocalDate.now());
		this.deposit2 = this.deposit2.setScale(2, RoundingMode.FLOOR);
    }
    
    @Test
	public void test() {
		/* from instructions : if a bike was originally worth a replacement value of £900 and the
		depreciation rate is 10%, then after three whole years have passed:
		under linear depreciation its value would be 900 − 3 × 0.1 × 900 = £630;
		whereas under double declining balance its value would be 900×(1−2×0.1)3 = £460.8.
		Under a deposit rate of 20% the deposit amounts would be £126 and £92.16 respectively.*/
		
		assertEquals(deposit1.stripTrailingZeros(), 
				(new BigDecimal(126)).stripTrailingZeros());
		assertEquals(deposit2.stripTrailingZeros(), 
				(new BigDecimal(92.16)).setScale(2, RoundingMode.CEILING));
		
	}

}
