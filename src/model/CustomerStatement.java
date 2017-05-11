package model;

import java.util.ArrayList;
import java.util.List;

public class CustomerStatement {
    private List<Rental> rentals = new ArrayList<>();
    private Customer customer;

    public CustomerStatement(Customer customer) {
        this.customer = customer;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Учет аренды для " + customer.getName() + "\n");

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

        return addDownColontitle(result, totalAmount,frequentRenterPoints).toString();
    }

    private StringBuilder addDownColontitle(StringBuilder result, double totalAmount, int frequentRenterPoints){
        //добавить нижний колонтитул
        result.append("Сумма задолженности составляет ").append(String.valueOf(totalAmount)).append("\n");
        result.append("Вы заработали ").append(String.valueOf(frequentRenterPoints)).append(" очков за активность");
        return result;
    }
}
