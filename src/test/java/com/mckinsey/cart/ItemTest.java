package com.mckinsey.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemTest {

	@Test
	public void toStringHasNameAndPrice() {
		String name = "sample";
		ItemType type = ItemType.OTHER;
		double price = 100.00;
		Item item = new Item(name, type, price);
		assertEquals(name, item.getName());
		assertEquals(type, item.getType());
		assertEquals(price, item.getPrice(), 0.00);
		assertTrue(item.toString().contains(name));
		assertTrue(item.toString().contains("" + price));
		assertFalse(item.toString().contains(type.name()));
	}

}
