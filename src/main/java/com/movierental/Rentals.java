package com.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

  public double getTotalAmount() {
    return this.stream().mapToDouble(each -> each.amount()).sum();
  }

  public int getFrequentRenterPoints() {
    return this.stream().mapToInt(each -> each.getFrequentRenterPoints()).sum();
  }

}
