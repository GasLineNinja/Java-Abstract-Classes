package store;

/*
 * An abstract class representing an item to be sold in a store by individual units
 */
public abstract class ItemByQuantity extends Item {
	
	protected int quantity;
	
	public ItemByQuantity(double pricePer, int quantity, String description) {
		super(pricePer,description);
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return quantity + " " + getDescription() + " sold @ $"+ getPricePer() +" per " + getDescription();
	}
	
	
	
	
	



	
	
	
}
