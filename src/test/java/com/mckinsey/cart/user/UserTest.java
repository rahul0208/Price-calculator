package com.mckinsey.cart.user;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class UserTest {
	@Test
	public void shouldGiveBackPropertiesAndtoString() {
		String name = "Rahul";
		UserType type = UserType.AFFILIATE;
		Date membershipDate = new Date();
		User user = new User(name, type, membershipDate);
		assertEquals(name, user.getName());
		assertEquals(type, user.getType());
		assertEquals(membershipDate, user.memeberSince());
		assertTrue(user.toString().contains(name));
		assertTrue(user.toString().contains(type.name()));
		assertTrue(user.toString().contains(membershipDate.toString()));
	}

	@Test
	public void shouldGiveBackApplicabeDiscountBasedOnType() {
		String name = "Rahul";
		UserType type = UserType.AFFILIATE;
		Date membershipDate = new Date();
		User user = new User(name, type, membershipDate);
		assertEquals(type.getPercentageDiscount(user),
				user.getApplicableDiscount());
	}

}
