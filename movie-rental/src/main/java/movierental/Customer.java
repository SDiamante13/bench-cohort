package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

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

        StringBuilder resultBuilder = new StringBuilder("Rental Record for " + getName() + "\n");
        for (Rental rental : rentals) {
            resultBuilder
                    .append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append(rental.getCharge())
                    .append("\n");
        }
        String result = resultBuilder.toString();

        // add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }

    private double getTotalCharge() {
        return rentals.stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder("<h1>Rental Record for <em>" + getName() + "</em></h1>\n<table>\n");

        for (Rental rental : rentals) {
            result
                    .append("<tr><td>")
                    .append(rental.getMovie().getTitle())
                    .append("</td><td>")
                    .append(rental.getCharge())
                    .append("</td></tr>\n");
        }
        result
                .append("</table>\n")
                .append("<p>Amount owed is <em>")
                .append(getTotalCharge())
                .append("</em></p>\n")
                .append("<p>You earned <em>")
                .append(getTotalFrequentRenterPoints())
                .append("</em> frequent renter points</p>");

        return result.toString();
    }
}


