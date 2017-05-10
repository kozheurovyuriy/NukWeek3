package model;

import java.util.*;

public class Customer {
    public static final int NEW_RELEASE = 1;

    private String name;
    private List<Rental> rentals = new ArrayList<>();
    public Customer (String name) {
        this.name = name;
    };
    public void addRental(Rental arg) {
        rentals.add(arg);
    }
    public String getName () {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        StringBuilder result = new StringBuilder("Учет аренды для " + getName() + "\n");

        for (Rental rental : rentals) {
            double thisAmount = 0;
            //определить сумму для каждой строки
            thisAmount = rental.getMovie().getMovieType().calculateAmount(rental.getDaysRented());
            // добавить очки для активного арендатора
            frequentRenterPoints ++;
            // бонус за аренду новинки на два дня
            if ((rental.getMovie().getMovieType() instanceof NewReleaseMovie) &&
                    rental.getDaysRented() > 1 ) frequentRenterPoints ++;
            //показать результаты для этой аренды
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");
            totalAmount += thisAmount;
        }
        //добавить нижний колонтитул
        result.append("Сумма задолженности составляет ").append(String.valueOf(totalAmount)).append("\n");
        result.append("Вы заработали ").append(String.valueOf(frequentRenterPoints)).append(" очков за активность");
        return result.toString();
    }
}
