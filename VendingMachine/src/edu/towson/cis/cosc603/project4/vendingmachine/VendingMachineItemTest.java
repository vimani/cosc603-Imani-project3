/**
 * 
 */
package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;
import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author NFJ6TVK
 *
 */
public class VendingMachineItemTest {
	/** Declaring necessary test objects for {@link VendingMachineItem} */
	VendingMachineItem firstItem, secondItem, thirdItem;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		firstItem = new VendingMachineItem("Juice", 5.50);
		secondItem = new VendingMachineItem("Cinnabon", 2.75);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	@Test (expected = VendingMachineException.class)
	public void testVendingMachineItem() {
		new VendingMachineItem("Chips", 0);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals("Cinnabon", secondItem.getName());
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#getPrice()}.
	 */
	@Test
	public void testGetPrice() {
		assertEquals(5.50, firstItem.getPrice(), 0.0001);
	}

}
