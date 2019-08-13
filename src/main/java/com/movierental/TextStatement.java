package com.movierental;

public class TextStatement {

  public String generate(Rentals rentals, String customerName) {
    final StringBuilder result = new StringBuilder();
    result.append("Rental Record for " + customerName + "\n");
    rentals.stream().forEach(each -> result.append("\t" + each.getMovie().getTitle() + "\t" +
        each.amount() + "\n"));
    result.append("Amount owed is " + rentals.getTotalAmount() + "\n");
    result.append("You earned " + rentals.getFrequentRenterPoints()
        + " frequent renter points");
    return result.toString();
  }
}
