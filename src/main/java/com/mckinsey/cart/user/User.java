package com.mckinsey.cart.user;

import java.util.Date;

public class User {
  private String name;
  private Date since;
  private UserType type;

  User(String name, UserType type, Date membershipDate) {
    this.name = name;
    this.type = type;
    this.since = membershipDate;
  }

  public String getName() {
    return name;
  }

  public UserType getType() {
    return type;
  }

  public Date memeberSince() {
    return since;
  }

  public int getApplicableDiscount() {
    return type.getPercentageDiscount(this);
  }

  @Override
  public String toString() {
    return name + " member of type " + type + " since " + since;
  }

}