package com.mckinsey.discounts;

import java.math.BigDecimal;

import com.mckinsey.cart.Cart;
import com.mckinsey.cart.Item;

class PercentageDiscountFilter extends DiscountFilter {

	private double discountPercent;

	public PercentageDiscountFilter(int percentage) {
		this.discountPercent = percentage / 100.00;
	}

	@Override
	public double computeDiscount(Cart cart) {
		double discount = 0;
		for (Item item : cart) {
			if (item.getType().ifPercentageDiscountAvailable()) {
				discount += item.getPrice() * discountPercent;
			}
		}
		return roundOffDiscount(discount);
	}

	double roundOffDiscount(double value) {
		BigDecimal bigDecimal = new BigDecimal(value);
		return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
