package main;

import model.*;

public class Main {

    public static void main(String[] args) {

        MovieType childrensMovie = new ChildrensMovie();
        MovieType regularMovie = new RegularMovie();
        MovieType newReleaseMovie = new NewReleaseMovie();

        Customer customer1 = new Customer("customerName1");

        CustomerStatement customerStatement1 = new CustomerStatement(customer1);

        customerStatement1.addRental(new Rental(new Movie(childrensMovie, "Titanic"), 5));
        customerStatement1.addRental(new Rental(new Movie(regularMovie,"Rembo"), 4));
        customerStatement1.addRental(new Rental(new Movie(newReleaseMovie,"OperationI"), 3));

        HtmlCreator htmlCreator = new HtmlCreator();
        htmlCreator.createHtmlFile(customerStatement1.statement());
    }
}

