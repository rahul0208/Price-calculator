package com.mckinsey.discounts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mckinsey.cart.Cart;
import com.mckinsey.cart.Item;
import com.mckinsey.cart.ItemType;

public class PercentageDiscountFilterTest {
	@Test
	public void shouldGiveDiscountBasedOnType() {
		PercentageDiscountFilter filter = new PercentageDiscountFilter(10);
		double computeDiscount = filter.computeDiscount(mockCart(
				ItemType.GROCERY, 100));
		assertEquals(0, computeDiscount, 0);
		computeDiscount = filter.computeDiscount(mockCart(ItemType.OTHER, 100));
		assertEquals(10, computeDiscount, 0);
	}

	@Test
	public void shouldGiveDiscountInPercentTerms() {
		PercentageDiscountFilter filter = new PercentageDiscountFilter(10);
		double computeDiscount = filter.computeDiscount(mockCart(
				ItemType.OTHER, 100));
		assertEquals(10, computeDiscount, 0);
		computeDiscount = filter.computeDiscount(mockCart(ItemType.OTHER, 211));
		assertEquals(21.1, computeDiscount, 0);
		computeDiscount = filter.computeDiscount(mockCart(ItemType.OTHER, 51));
		assertEquals(5.1, computeDiscount, 0.0);
	}

	static Cart mockCart(ItemType type, int cartValue) {
		Cart cart = new Cart();
		cart.addItem(new Item("name", type, cartValue));
		return cart;
	}
}
