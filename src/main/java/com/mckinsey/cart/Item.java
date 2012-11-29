package com.mckinsey.cart;

public class Item {
	private double price;
	private String name;
	private ItemType type;

	public Item(String name, ItemType type, double price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}

	@Override
	public String toString() {
		return this.name + " #### " + this.price;
	}

	public ItemType getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}