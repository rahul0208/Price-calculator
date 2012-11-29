package com.mckinsey.discounts;

import com.mckinsey.cart.Cart;

class AbsoluteDiscountFilter extends DiscountFilter {
	private int price;
	private int discount;

	public AbsoluteDiscountFilter(int price, int discountValue) {
		this.price = price;
		this.discount = discountValue;
	}

	@Override
	public double computeDiscount(Cart cart) {
		double totalPrice = cart.getTotalPrice();
		return ((int)totalPrice / price) * discount;
	}

}
