package com.mckinsey.cart;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemTypeTest {
	@Test
	public void groceriesShouldNotHavePercentageDiscounts() {
		assertFalse(ItemType.GROCERY.ifPercentageDiscountAvailable());
		assertTrue(ItemType.OTHER.ifPercentageDiscountAvailable());
	}
}
