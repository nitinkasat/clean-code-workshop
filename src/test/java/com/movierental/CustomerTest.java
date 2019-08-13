package com.movierental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

  private Customer customer;

  @Before
  public void setup() {
    customer = new Customer("Nitin");
  }

  @Test
  public void statementForRegularMovieRentalLessThan2Days() {
    Movie movie = new Movie("Harry potter - Part 1", Movie.REGULAR);
    customer.addRental(new Rental(movie, 2));
    assertEquals("Rental Record for Nitin\n"
        + "\tHarry potter - Part 1\t2.0\n"
        + "Amount owed is 2.0\n"
        + "You earned 1 frequent renter points", customer.statement());
  }

  @Test
  public void statementForRegularMovieRentalMoreThan2Days() {
    Movie movie = new Movie("Harry potter - Part 1", Movie.REGULAR);
    customer.addRental(new Rental(movie, 3));
    assertEquals("Rental Record for Nitin\n"
        + "\tHarry potter - Part 1\t3.5\n"
        + "Amount owed is 3.5\n"
        + "You earned 1 frequent renter points", customer.statement());
  }

  @Test
  public void statementForNewReleaseMovieRentalMoreThan1Day() {
    Movie movie = new Movie("Harry potter - Part 1", Movie.NEW_RELEASE);
    customer.addRental(new Rental(movie, 3));
    assertEquals("Rental Record for Nitin\n"
        + "\tHarry potter - Part 1\t9.0\n"
        + "Amount owed is 9.0\n"
        + "You earned 2 frequent renter points", customer.statement());
  }

  @Test
  public void statementForChildrenMovieRentalOfLessThan3Days() {
    Movie movie = new Movie("Harry potter - Part 1", Movie.CHILDRENS);
    customer.addRental(new Rental(movie, 2));
    assertEquals("Rental Record for Nitin\n"
        + "\tHarry potter - Part 1\t1.5\n"
        + "Amount owed is 1.5\n"
        + "You earned 1 frequent renter points", customer.statement());
  }

  @Test
  public void statementForChildrenMovieRentalOfMoreThan3Days() {
    Movie movie = new Movie("Harry potter - Part 1", Movie.CHILDRENS);
    customer.addRental(new Rental(movie, 4));
    assertEquals("Rental Record for Nitin\n"
        + "\tHarry potter - Part 1\t3.0\n"
        + "Amount owed is 3.0\n"
        + "You earned 1 frequent renter points", customer.statement());
  }

  @Test
  public void statementForMultipleMovies() {
    Movie movie1 = new Movie("Harry potter - Part 1", Movie.CHILDRENS);
    customer.addRental(new Rental(movie1, 4));
    Movie movie2 = new Movie("Harry potter - Part 1", Movie.NEW_RELEASE);
    customer.addRental(new Rental(movie2, 2));
    assertEquals("Rental Record for Nitin\n"
        + "\tHarry potter - Part 1\t3.0\n"
        + "\tHarry potter - Part 1\t6.0\n"
        + "Amount owed is 9.0\n"
        + "You earned 3 frequent renter points", customer.statement());
  }

  @Test
  public void statementForNoMovies() {
    assertEquals("Rental Record for Nitin\n"
        + "Amount owed is 0.0\n"
        + "You earned 0 frequent renter points", customer.statement());
  }


  @Test
  public void htmlStatementForChildrenMovieRentalOfMoreThan3Days() {
    Movie movie = new Movie("Harry potter - Part 1", Movie.CHILDRENS);
    customer.addRental(new Rental(movie, 4));
    assertEquals("<h1>Rental Record for <b>Nitin</b></h1><br/>"
        + "\tHarry potter - Part 1\t3.0<br/>"
        + "Amount owed is <b>3.0</b><br/>"
        + "You earned <b>1</b> frequent renter points", customer.htmlStatement());
  }


}