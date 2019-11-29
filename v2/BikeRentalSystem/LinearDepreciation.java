
import java.math.BigDecimal;
import java.time.LocalDate;

public class LinearDepreciation implements ValuationPolicy {

    private BigDecimal depreciationRate;
    private int productionYear;
    private BigDecimal depositRate;
	
	public LinearDepreciation(double depreciationRate, int productionYear) {
		this.depreciationRate = new BigDecimal(depreciationRate);
		this.productionYear = productionYear;
	}
	
	public BigDecimal calculateValue(Bike bike, LocalDate date) {
		this.depositRate = bike.getBikeProvider().getDepositRate();
		int age = date.getYear() - productionYear;
		BigDecimal replacementValue = bike.getReplacementValue();
		BigDecimal newValue = replacementValue.subtract(
				new BigDecimal(age).multiply(depreciationRate).multiply(replacementValue));
	    BigDecimal deposit = depositRate.multiply(newValue);
		return deposit;
	}
}
