package com.mckinsey.cart.user;

import java.util.Date;

public class UserBuilder {
	private String name;
	private UserType type;
	private Date since;

	public UserBuilder(String name) {
		this.name = name;
	}

	public UserBuilder setUserType(UserType type) {
		this.type = type;
		return this;
	}

	public UserBuilder setMemberShipDate(Date date) {
		this.since = date;
		return this;
	}

	public User createUser() {
		if (type == null)
			type = UserType.CUSTOMER;
		if (since == null)
			since = new Date();
		return new User(name, type, since);
	}
}