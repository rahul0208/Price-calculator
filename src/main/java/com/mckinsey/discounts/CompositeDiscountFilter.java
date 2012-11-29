package com.mckinsey.discounts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mckinsey.cart.Cart;

class CompositeDiscountFilter extends DiscountFilter {
	private List<DiscountFilter> filters;

	public CompositeDiscountFilter() {
		filters = new ArrayList<DiscountFilter>();
	}

	@Override
	public double computeDiscount(Cart cart) {
		double totalDiscount = 0;
		for (DiscountFilter filter : filters) {
			totalDiscount += filter.computeDiscount(cart);
		}
		return totalDiscount;
	}

	public void addFilter(DiscountFilter filter) {
		filters.add(filter);
	}

	public List<DiscountFilter> getFilters() {
		return Collections.unmodifiableList(filters);
	}

}
