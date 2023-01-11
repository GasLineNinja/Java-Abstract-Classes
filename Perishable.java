package store;

public interface Perishable {
	
	//TODO declare the required methods for this interface (see the handout)
	
	public abstract void addDay();
	
	public abstract boolean isExpired();
}
