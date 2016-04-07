/**
 * 
 */
package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author NFJ6TVK
 *
 */
public class VendingMachineTest {
	VendingMachine yorkVending = new VendingMachine();
	VendingMachineItem ultimateItem = new VendingMachineItem("Gum", 1.75);
	VendingMachineItem firstItem, secondItem, thirdItem, forthItem;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		firstItem = new VendingMachineItem("Juice", 5.50);
		secondItem = new VendingMachineItem("Cinnabon", 2.75);
		forthItem = new VendingMachineItem("Honeybun", 1.75);
		yorkVending.addItem(ultimateItem, VendingMachine.D_CODE);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#VendingMachine()}.
	 */
	@Test 
	public void testVendingMachine() {
		assertEquals(0.00, yorkVending.balance, 0.001);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem, java.lang.String)}.
	 */
	@Test (expected = VendingMachineException.class)
	public void testAddItem() {
		for(int i = 0; i <2; i++)
		yorkVending.addItem(firstItem, "A");
		//yorkVending.addItem(secondItem, "E");
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#insertMoney(double)}.
	 */
	@Test (expected = VendingMachineException.class)
	public void testInsertMoney() {
		yorkVending.insertMoney(-1);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#getBalance()}.
	 */
	@Test
	public void testGetBalance() {
		yorkVending.insertMoney(20.00);
		assertEquals(20.00, yorkVending.getBalance(), 0.001);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 */
	@Test
	public void testMakePurchase() {
		yorkVending.insertMoney(20.00);
		assertTrue(yorkVending.makePurchase(VendingMachine.D_CODE));
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#returnChange()}.
	 */
	@Test
	public void testReturnChange() {
		yorkVending.addItem(firstItem, "A");
		yorkVending.addItem(firstItem, "B");
		yorkVending.addItem(firstItem, "C");
		yorkVending.insertMoney(8.00);
		yorkVending.makePurchase(VendingMachine.A_CODE);
		assertEquals(2.50,yorkVending.returnChange(),0.001);
		assertFalse(yorkVending.makePurchase(VendingMachine.A_CODE));
		yorkVending.returnChange();
		assertFalse(yorkVending.makePurchase(VendingMachine.A_CODE));
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 */
	@Test (expected = VendingMachineException.class)
	public void testRemoveItem() {
		yorkVending.removeItem(VendingMachine.D_CODE);
		yorkVending.removeItem(VendingMachine.D_CODE);
		//assertTrue(yorkVending.makePurchase(VendingMachine.D_CODE));
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 */
	@Test (expected = VendingMachineException.class)
	public void testAnotherRemoveItem() {
		yorkVending.removeItem("E");
		//yorkVending.removeItem(VendingMachine.D_CODE);
		//assertTrue(yorkVending.makePurchase(VendingMachine.D_CODE));
	}

}
