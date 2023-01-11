package store;
public interface Taxable {
	
	public static final double TAXRATE = 0.05;
	
	/**
	 * @return the tax for the Taxable object
	 */
	public abstract double getTax();
	
	/**
	 * @return the pretax subtotal for the Taxable object
	 */
	public abstract double getSubTotal();
}
