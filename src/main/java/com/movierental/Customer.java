package com.movierental;


public class Customer {

  private String name;
  private Rentals rentals = new Rentals();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    return new TextStatement().generate(rentals, getName());
  }

  public String htmlStatement() {
    return new HtmlStatement().generate(rentals, getName());
  }

}

