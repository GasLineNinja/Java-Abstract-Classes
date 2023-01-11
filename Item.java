package store;

/*
 * An abstract class representing an item to be sold in a store
 */
public abstract class Item {
	private double pricePer;
	private String description;
	
	
	
	public Item(double pricePer, String description) {
		this.pricePer = pricePer;
		this.description = description;
	}
	
	public final double getPricePer() {
		return pricePer;
	}
	
	public final String getDescription() {
		return description;
	}
	

	public abstract double getTotal();
}
 
