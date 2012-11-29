package com.mckinsey.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CartTest {
	@Test
	public void shouldGiveBackAllItemsInCart() {
		Cart cart = new Cart();
		int count = 0;
		for (; count < 5; count++) {
			cart.addItem(createSampleItem(100));
		}
		int itemasInCart = 0;
		for (Item item : cart) {
			itemasInCart++;
		}
		assertEquals(count, itemasInCart);
	}

	@Test
	public void shouldGiveTotalValueOfCart() {
		Cart cart = new Cart();
		int count = 0;
		int price = 100;
		for (; count < 5; count++) {
			cart.addItem(createSampleItem(price));
		}
		assertEquals(price * count, cart.getTotalPrice(), 0.00);
	}

	@Test
	public void toStringShouldPrintCart() {
		Cart cart = new Cart();
		int count = 0;
		int price = 100;
		for (; count < 5; count++) {
			cart.addItem(createSampleItem(price));
		}
		Item item = createSampleItem(price);
		assertTrue(cart.toString().contains(item.getName()));
		assertTrue(cart.toString().contains("" + item.getPrice()));
		assertTrue(cart.toString().contains("" + cart.getTotalPrice()));
	}

	private Item createSampleItem(double price) {
		return new Item("sample", ItemType.GROCERY, price);
	}
}
