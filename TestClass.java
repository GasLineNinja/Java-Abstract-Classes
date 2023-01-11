
import junit.framework.TestCase;
import store.*;

public class TestClass extends TestCase {

	
	BakedGood bake1,bake2;
	TobaccoProduct tob1,tob2;
	Produce prod1,prod2;
	
	public void setUp() {
		bake1 = new BakedGood(3, 3, "donut");
		bake2 = new BakedGood(2.99, 2, "Italian Bread");
		
		tob1 = new TobaccoProduct(8.99, 5, "Cigarette Carton");
		tob2 = new TobaccoProduct(5.99, 1, "Cigar");
		
		prod1 = new Produce(0.49, 2, "bananas", 7);
		prod2 = new Produce(1.49, 3, "Fuji Apples", 14);
	}
	
	//testing bakedGoods
	public void test01(){
		assertEquals(9.0, bake1.getTotal());
		assertEquals(5.98, bake2.getTotal());
		
		assertEquals("3 donut sold @ $3.0 per donut", bake1.toString());
		assertEquals("2 Italian Bread sold @ $2.99 per Italian Bread", bake2.toString());
		
		assertFalse(bake1.isExpired());
		
		boolean everExpired = false;
		for(int i=0; i<100; i++) {
			bake1.addDay();
			if(bake1.isExpired())
				everExpired = true;
			if(everExpired)
				assertTrue(bake1.isExpired());
		}
		
	}
	
	
	
	//testing TobaccoProducts
	public void test02(){
		
		assertEquals(44.95,tob1.getSubTotal(), 0.01);
		assertEquals(5.99,tob2.getSubTotal(), 0.01);
		
		assertEquals(14.75,tob1.getTax(), 0.01);
		assertEquals(2.8,tob2.getTax(), 0.01);
		
		assertEquals(59.7,tob1.getTotal(), 0.01);
		assertEquals(8.79,tob2.getTotal(), 0.01);
		
		assertEquals("5 Cigarette Carton sold @ $8.99 per Cigarette Carton", tob1.toString());
		assertEquals("1 Cigar sold @ $5.99 per Cigar", tob2.toString());

		assertEquals(59.7,tob1.getTotal(), 0.01);
		assertEquals(8.79,tob2.getTotal(), 0.01);
	}
	
	
	//testing Produce
	public void test03(){
		assertEquals(1.03, prod1.getTotal(), 0.01);
		assertEquals(4.69, prod2.getTotal(), 0.01);
		
		assertFalse(prod1.isExpired());
		assertFalse(prod2.isExpired());
		
		for(int i=0; i<8; i++) {
			assertFalse(prod1.isExpired());
			prod1.addDay();
		}
		
		assertTrue(prod1.isExpired());
		
		for(int i=0; i<8; i++) {
			prod1.addDay();
			assertTrue(prod1.isExpired());
		}
		
		
		assertEquals("bananas: 2.0 LB's @ $0.49 per LB.", prod1.toString());
		assertEquals("Fuji Apples: 3.0 LB's @ $1.49 per LB.", prod2.toString());
	}
	
	//testing Perishable interface
	public void test04(){
		Perishable per1 = prod1;
		Perishable per2 = prod2;
		
		assertFalse(per1.isExpired());
		assertFalse(per2.isExpired());
		
		for(int i=0; i<8; i++) {
			assertFalse(per1.isExpired());
			per1.addDay();
		}
		
		assertTrue(per1.isExpired());
		
		for(int i=0; i<8; i++) {
			per1.addDay();
			assertTrue(per1.isExpired());
		}
		
		
		assertEquals("bananas: 2.0 LB's @ $0.49 per LB.", per1.toString());
		assertEquals("Fuji Apples: 3.0 LB's @ $1.49 per LB.", per2.toString());
	}
	
	//testing ItemByWeight abstract class
	public void test05() {
		ItemByWeight ibw = prod1;
		assertEquals(1.03, ibw.getTotal(), 0.01);
		assertEquals("bananas: 2.0 LB's @ $0.49 per LB.", ibw.toString());
		assertEquals(0.49, ibw.getPricePer());
		assertEquals("bananas", ibw.getDescription());
	}
	
	//testing Store
	public void test06() {
		Store store = new Store();
		assertNull(store.getItem(0));
		assertNull(store.getItem(1));
		//add some things
		store.addItem(bake1);
		store.addItem(bake2);
		store.addItem(tob1);
		store.addItem(tob2);
		store.addItem(prod1);
		store.addItem(prod2);
		assertEquals(bake1, store.getItem(0));
		assertEquals(bake2, store.getItem(1));
		assertNull(store.getItem(-1));
		//sell some things
		assertEquals(5.98, store.sellItem(1));
		assertNull(store.getItem(1));
		assertEquals(0.0, store.sellItem(1));
		store.addItem(prod2);
		assertEquals(prod2, store.getItem(1));
		store.sellItem(5); //other prod2
		assertEquals(prod2, store.getItem(1));
		//add a lot of things
		for (int i=0; i<100; i++)
			store.addItem(bake1);
		assertEquals(bake1, store.getItem(49));
		assertNull(store.getItem(50));
		//advance
		store.removeExpiredItems();
		assertEquals(prod1, store.getItem(4));
		for (int i=0; i<10; i++)
			store.advanceDay();
		store.removeExpiredItems();
		assertNull(store.getItem(4));
		//advance more
		assertEquals(prod2, store.getItem(1));
		for (int i=0; i<10; i++)
			store.advanceDay();
		store.removeExpiredItems();
		assertNull(store.getItem(1));
	}
}
