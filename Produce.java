package store;

public class Produce extends ItemByWeight implements Taxable, Perishable{
	
	private int shelfLife;
	
	public Produce(double pricePerPound, double weightInLBs, String description, int shelfLife) {
		//TODO initialize fields appropriately
		super(pricePerPound, description, weightInLBs);
		this.shelfLife = shelfLife;
		this.weightInLBs = weightInLBs;
		
	}

	
	@Override
	public double getTax() {
		//TODO return the total tax on this item, based on the subtotal and the TAXRATE
		return getSubTotal() * TAXRATE;
	}

	
	@Override
	public double getSubTotal() {
		//TODO return the subtotal, based on the price per pound and the weight
		return  getPricePer() * weightInLBs;
	}

	
	@Override
	public double getTotal() {
		//TODO return the total, based on the combination of the subtotal and the tax
		return getSubTotal() + getTax();
	}
	
	//TODO add methods to satisfy the Perishable interface
	//isExpired: return true if there are fewer than 0 days remaining on the shelf life
	//addDay: remove one day from the shelf life
	
	public boolean isExpired() {
		if (shelfLife < 0) {return true;}
		return false;
		}


	@Override
	public void addDay() {
		shelfLife = shelfLife - 1;
	}
	
}
