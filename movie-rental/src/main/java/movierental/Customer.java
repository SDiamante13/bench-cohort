package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : _rentals) {
            double thisAmount = 0;

            //determine amounts for each line
            thisAmount = rental.getRentalAmount(thisAmount);

            // add frequent renter points
            frequentRenterPoints = getFrequentRenterPoints(frequentRenterPoints, rental);

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }

    private static int getFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        frequentRenterPoints++;
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)) {
            if (rental.getDaysRented() > 1) frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}


