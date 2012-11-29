package com.mckinsey.discounts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mckinsey.cart.Cart;

public class CompositeDiscountFilterTest {
	@Test
	public void shouldGiveBackAllFilters() {
		CompositeDiscountFilter filter = new CompositeDiscountFilter();
		int count = 0;
		for (; count < 5; count++) {
			filter.addFilter(new MockFilter(0));
		}
		assertEquals(count, filter.getFilters().size());
	}

	@Test
	public void shouldApplyAllFiltersForDiscount() {
		CompositeDiscountFilter filter = new CompositeDiscountFilter();
		double totalDiscount = 0;
		double discount = 10;
		for (int count = 0; count < 5; count++) {
			discount = discount + count;
			totalDiscount += discount;
			filter.addFilter(new MockFilter(discount));
		}
		double computeDiscount = filter.computeDiscount(new Cart());
		assertEquals(totalDiscount, computeDiscount, 0.0);
	}

	class MockFilter extends DiscountFilter {
		double discount;

		MockFilter(double discount) {
			this.discount = discount;
		}

		@Override
		public double computeDiscount(Cart cart) {
			return discount;
		}

	}
}
