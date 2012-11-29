package com.mckinsey.cart.user;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class UserTypeTest {

	@Test
	public void shouldGiveFlatDiscountForEmployes() {
		Calendar instance = Calendar.getInstance();
		assertEquals(30,
				UserType.EMPLOYEE.getPercentageDiscount(createUser(null)));
		assertEquals(30,
				UserType.EMPLOYEE.getPercentageDiscount(createUser(instance
						.getTime())));
		instance.set(Calendar.YEAR, 2000);
		assertEquals(30,
				UserType.EMPLOYEE.getPercentageDiscount(createUser(instance
						.getTime())));
	}

	@Test
	public void shouldGiveFlatDiscountForAffiliates() {
		Calendar instance = Calendar.getInstance();
		assertEquals(10,
				UserType.AFFILIATE.getPercentageDiscount(createUser(null)));
		assertEquals(10,
				UserType.AFFILIATE.getPercentageDiscount(createUser(instance
						.getTime())));
		instance.set(Calendar.YEAR, 2000);
		assertEquals(10,
				UserType.AFFILIATE.getPercentageDiscount(createUser(instance
						.getTime())));
	}

	@Test
	public void shouldCheckDiscountsForCustomers() {
		Calendar instance = Calendar.getInstance();
		assertEquals(0,
				UserType.CUSTOMER.getPercentageDiscount(createUser(null)));
		assertEquals(0,
				UserType.CUSTOMER.getPercentageDiscount(createUser(instance
						.getTime())));
		instance.set(Calendar.YEAR, 2010);
		assertEquals(5,
				UserType.CUSTOMER.getPercentageDiscount(createUser(instance
						.getTime())));
	}

	private User createUser(Date membershipDate) {
		return new User("Rahul", null, membershipDate);
	}

}
