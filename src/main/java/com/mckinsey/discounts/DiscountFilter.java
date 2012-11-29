package com.mckinsey.discounts;

import com.mckinsey.cart.Cart;
import com.mckinsey.cart.user.User;

public abstract class DiscountFilter {
	public abstract double computeDiscount(Cart cart);

	public static DiscountFilter createFilter(User user) {
		CompositeDiscountFilter filter = new CompositeDiscountFilter();
		filter.addFilter(new AbsoluteDiscountFilter(100, 5));
		filter.addFilter(new PercentageDiscountFilter(user
				.getApplicableDiscount()));
		return filter;
	}
}
