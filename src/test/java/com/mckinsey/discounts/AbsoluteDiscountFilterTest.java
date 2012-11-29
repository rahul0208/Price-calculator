package com.mckinsey.discounts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mckinsey.cart.Cart;
import com.mckinsey.cart.Item;
import com.mckinsey.cart.ItemType;

public class AbsoluteDiscountFilterTest {

	@Test
	public void shouldComputeDiscountValueInAbsoluteTerms() {
		AbsoluteDiscountFilter filter = new AbsoluteDiscountFilter(100, 5);
		assertEquals(5.0, filter.computeDiscount(mockCartForvalue(100)), 0);
		assertEquals(15.0, filter.computeDiscount(mockCartForvalue(315)), 0);
		assertEquals(45.0, filter.computeDiscount(mockCartForvalue(990)), 0);
	}

	private Cart mockCartForvalue(int cartValue) {
		Cart cart = new Cart();
		cart.addItem(new Item("name", ItemType.GROCERY, cartValue));
		return cart;
	}

}
