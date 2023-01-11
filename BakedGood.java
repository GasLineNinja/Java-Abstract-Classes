package store;

public class BakedGood extends ItemByQuantity implements Perishable{
	
	private boolean isMoldy;
	
	public BakedGood(double pricePer, int quantity, String description) {
		super(pricePer, quantity, description);
	}
	
	
	@Override
	public double getTotal() {
		return getPricePer()*quantity;
	}


	@Override
	public boolean isExpired() {
		return isMoldy;
	}


	@Override
	public void addDay() {
		if(!isMoldy)
			isMoldy = getsMold();
	}
	
	private boolean getsMold() {
		return(Math.random() < 0.2);
	}

	
	
}
