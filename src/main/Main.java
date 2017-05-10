package main;

import model.*;

public class Main {

    public static void main(String[] args) {

        MovieType childrensMovie = new ChildrensMovie();
        MovieType regularMovie = new RegularMovie();
        MovieType newReleaseMovie = new NewReleaseMovie();

        Customer customer1 = new Customer("customerName1");

        customer1.addRental(new Rental(new Movie(childrensMovie, "Titanic"), 5));
        customer1.addRental(new Rental(new Movie(regularMovie,"Rembo"), 4));
        customer1.addRental(new Rental(new Movie(newReleaseMovie,"OperationI"), 3));

        System.out.println(customer1.statement());


    }
}

