package store;

/*
 * A class that represents a store. All of its items are stored in the goods array.
 * This class supports adding items, selling items, advancing a day, and removing expired items.
 */
public class Store {
	//use this constant in your code.
	//don't type out "50"
	public static final int MAX_SIZE = 50;

	private Item[] goods;

	/*
	 * Create an empty store
	 */
	public Store() {
		goods = new Item[MAX_SIZE];
	}

	/**
	 * Return the item at index i
	 * If i is out of bounds, return null
	 * @param i index of the item to return
	 * @return the item at i
	 */
	public Item getItem(int i) {
		//TODO return the item at i
		if ( i >= MAX_SIZE || i < 0) {return null;}
		return goods[i];
	}

	/**
	 * Find the first open (null) space in the array, and add the item there
	 * If the array is full, don't add anything
	 * If the item to be added is null, don't add anything
	 * @param item to be added
	 */
	public void addItem(Item item) {
		//TODO find the first open (null) index
		//Add the Item at that index
		for (int i = 0; i < MAX_SIZE; i++) {
			if (goods[i] == null) {goods[i] = item; break;}
		}
	}


	/**
	 * Remove the ith item from the array and return its total price, including any tax
	 * If there is no item at index i, return 0.0
	 * If i is not a valid index, return 0.0
	 * @param i index of the item to buy
	 * @return the total price of the item
	 */
	public double sellItem(int i) {
		//TODO check goods at the given index
		//If there is an Item, return its total, and remove it (replace it with null)
		if (goods[i] == null) {return 0.0;}
		if (i < 0 || i > MAX_SIZE) {return 0.0;}
		Item tempgoods = goods[i];
		goods[i] = null;
		return tempgoods.getTotal();

	}

	/**
	 * Advance a single day
	 * This means each item in the goods array that is Perishable must have a day added
	 */
	public void advanceDay() {
		//TODO check each Item in goods
		//if it is an instance of Perishable
		//call its addDay method
		for (int i = 0; i < goods.length; i++) {
			if (goods[i] instanceof Perishable) {
				Perishable p = (Perishable)goods[i];
				p.addDay();
			}
		}
	}


	/**
	 * Remove all expired items from the store
	 */
	public void removeExpiredItems() {
		//TODO check each Item in goods
		//if it is an instance of Perishable
		//if it is expired
		//remove it (replace it with null)
		for (int i = 0; i < MAX_SIZE; i++) {
			if (goods[i] instanceof Perishable)  {
				Perishable p = (Perishable)goods[i];
				if (p.isExpired()) {goods[i] = null;}
				
			}
		}
	}


}
