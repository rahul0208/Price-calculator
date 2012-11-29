package com.mckinsey.cart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart implements Iterable<Item> {
	private List<Item> items;

	public Cart() {
		items = new ArrayList<Item>();
	}

	public double getTotalPrice() {
		double price = 0;
		for (Item item : items) {
			price += item.getPrice();
		}
		return price;
	}

	public Cart addItem(Item selectedItem) {
		items.add(selectedItem);
		return this;
	}

	@Override
	public Iterator<Item> iterator() {
		return items.iterator();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Item item : items) {
			builder.append(item.toString());
			builder.append("\n");
		}
		builder.append("Total Cart cost ### " + getTotalPrice());
		return builder.toString();
	}

}
