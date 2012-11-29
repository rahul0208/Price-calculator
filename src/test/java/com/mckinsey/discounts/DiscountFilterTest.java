package com.mckinsey.discounts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.mckinsey.cart.user.UserBuilder;

public class DiscountFilterTest {

	@Test
	public void shouldGiveBackInitializedCompositeFilter() {
		DiscountFilter filter = DiscountFilter.createFilter(new UserBuilder(
				"Rahul").createUser());
		assertTrue(filter instanceof CompositeDiscountFilter);
		CompositeDiscountFilter discountFilter = (CompositeDiscountFilter) filter;
		List<DiscountFilter> filters = discountFilter.getFilters();
		assertEquals(2, filters.size());
		assertTrue(filters.get(0) instanceof AbsoluteDiscountFilter);
		assertTrue(filters.get(1) instanceof PercentageDiscountFilter);
	}

}
