package store;

/*
 * An abstract class representing an item to be sold in a store by weight in LBs
 */
public abstract class ItemByWeight extends Item{
	
	

	protected double weightInLBs;
	
	//TODO implement the constructor and the toString method
	//The constructor should have 3 parameters, two of which are passed on to the inherited constructor
	//The toString method should match this format:
	//	<description>: <weightInLBs> LB's @ $<getPricePer()> per LB.
	
	public ItemByWeight(double pricePer, String description, double weightInLBs) {
		super(pricePer, description);
		this.weightInLBs = weightInLBs;
	}
	
	public String toString() {
		return getDescription() + ": " + weightInLBs + " LB's @ $" + getPricePer() + " per LB.";}
	
	
	
}
