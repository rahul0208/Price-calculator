package com.mckinsey.cart;

public enum ItemType {
  GROCERY {
    @Override
    public boolean ifPercentageDiscountAvailable() {
      return false;
    }
  },
  OTHER;

  public boolean ifPercentageDiscountAvailable() {
    return true;
  }
}