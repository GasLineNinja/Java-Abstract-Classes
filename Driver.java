import store.*;

public class Driver {
	//TODO write a main method that will test your store
	//It should do the following
	//1. Create a Store
	public static void main(String[] args){
		Store store = new Store();
		
	//2. Add a number of Items to the Store (Make sure at least 5 are Produce)
		Produce prod1 = new Produce(.79, 3.0, "Carrot", 7);
		Produce prod2 = new Produce(1.79, 2.5, "Eggplant", 5);
		Produce prod3 = new Produce(1.02, .5, "Mushroom", 12);
		Produce prod4 = new Produce(1.50, 5.0, "Watermelon", 7);
		Produce prod5 = new Produce(.25, .2, "Cilantro", 4);
		Produce prod6 = new Produce(.98, 2.0, "Potato", 14);
		Produce prod7 = new Produce(2.50, 3.0, "Pineapple", 7);
		Produce prod8 = new Produce(1.00, 1.0, "Green Beans", 7);
		
		TobaccoProduct tobac1 = new TobaccoProduct(5.50, 2, "Pack of Ciggarettes");
		TobaccoProduct tobac2 = new TobaccoProduct(20.50, 1, "Carton of Ciggarettes");
		TobaccoProduct tobac3 = new TobaccoProduct(8.75, 6, "Cigar");
		
		BakedGood bake1 = new BakedGood(2.50, 3, "Muffin");
		BakedGood bake2 = new BakedGood(1.75, 2, "Scone");
		BakedGood bake3 = new BakedGood(1.25, 6, "Donut");
		
		store.addItem(prod1);
		store.addItem(prod2);
		store.addItem(prod3);
		store.addItem(prod4);
		store.addItem(prod5);
		store.addItem(prod6);
		store.addItem(prod7);
		store.addItem(prod8);
		store.addItem(tobac1);
		store.addItem(tobac2);
		store.addItem(tobac3);
		store.addItem(bake1);
		store.addItem(bake2);
		store.addItem(bake3);
		
	//3. Write a loop that will check every item in the Store and see if it is taxable
		double totalTax = 0;
		for (int i = 0; i <= Store.MAX_SIZE; ++i) {
			if(store.getItem(i) instanceof Taxable) {
			Taxable tax = (Taxable)store.getItem(i);
			
	//4. Add up the tax of all the taxable items
			totalTax += tax.getTax();
			}
		}
	//5. Print out the total tax for the items
		System.out.println(totalTax);
			
		
	}

	
}
