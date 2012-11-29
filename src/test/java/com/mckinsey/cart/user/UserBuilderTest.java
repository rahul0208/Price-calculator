package com.mckinsey.cart.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class UserBuilderTest {
	@Test
	public void shouldBuildAUserWithDefaults() {
		String name = "Rahul";
		UserBuilder builder = new UserBuilder(name);
		User user = builder.createUser();
		assertEquals(name, user.getName());
		assertEquals(UserType.CUSTOMER, user.getType());
		assertNotNull(user.memeberSince());
	}

	@Test
	public void shouldBuildAUserWithSpecifics() {
		String name = "Rahul";
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.MONTH, 1);
		Date date=instance.getTime();
		UserType type = UserType.AFFILIATE;
		UserBuilder builder = new UserBuilder(name).setUserType(type)
				.setMemberShipDate(date);
		User user = builder.createUser();
		assertEquals(name, user.getName());
		assertEquals(type, user.getType());
		assertEquals(date, user.memeberSince());
	}
}
