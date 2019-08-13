package com.movierental;

public class HtmlStatement {

  public String generate(Rentals rentals, String customerName) {
    final StringBuilder result = new StringBuilder();
    result.append("<h1>Rental Record for <b>" + customerName + "</b></h1><br/>");
    rentals.stream().forEach(each -> result.append("\t" + each.getMovie().getTitle() + "\t" +
        String.valueOf(each.amount()) + "<br/>"));
    //add footer lines result
    result.append("Amount owed is <b>" + rentals.getTotalAmount() + "</b><br/>");
    result.append("You earned <b>" + rentals.getFrequentRenterPoints()
        + "</b> frequent renter points");
    return result.toString();
  }
}
