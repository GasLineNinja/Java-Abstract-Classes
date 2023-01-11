package store;

public class TobaccoProduct extends ItemByQuantity implements Taxable {

	
	
	
	public TobaccoProduct(double pricePer, int quantity, String description) {
		super(pricePer, quantity, description);
	}

	
	
	@Override
	public double getTax() {
		//TODO add in an extra tax of 2.50 per unit
		return (getSubTotal() * TAXRATE) + (quantity * 2.50);
	}

	
	@Override
	public double getSubTotal() {
		return getPricePer() * quantity;
	}

	@Override
	public double getTotal() {
		return getTax() + getSubTotal();
	}

	
}
