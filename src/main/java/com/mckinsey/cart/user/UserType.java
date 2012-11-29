package com.mckinsey.cart.user;

import java.util.Calendar;

public enum UserType {
	EMPLOYEE {
		@Override
		public int getPercentageDiscount(User user) {
			return 30;
		}
	},
	AFFILIATE {
		@Override
		public int getPercentageDiscount(User user) {
			return 10;
		}
	},
	CUSTOMER {
		@Override
		public int getPercentageDiscount(User user) {
			Calendar instance = Calendar.getInstance();
			if (user.memeberSince() != null)
				instance.setTime(user.memeberSince());
			formatDate(instance).add(Calendar.YEAR, 2);
			Calendar currentDate = formatDate(Calendar.getInstance());
			if (instance.compareTo(currentDate) <= 0) {
				return 5;
			}
			return 0;
		}

		private Calendar formatDate(Calendar instance) {
			instance.set(Calendar.HOUR, 0);
			instance.set(Calendar.MINUTE, 0);
			instance.set(Calendar.SECOND, 0);
			instance.set(Calendar.MILLISECOND, 0);
			return instance;
		}
	};

	abstract public int getPercentageDiscount(User user);
}
