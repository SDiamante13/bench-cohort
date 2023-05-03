package movierental;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {

    @Test
    void statementIsPrintedForCustomerRentingMovies() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

        String expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points";

        assertThat(customer.statement()).isEqualTo(expected);
    }

    @Test
    void statementIsPrintedInHTMLForCustomerRentingMovies() {
        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

        String expected = "" +
                "<h1>Rental Record for <em>Bob</em></h1>\n" +
                "<table>\n" +
                "<tr><td>Jaws</td><td>2.0</td></tr>\n" +
                "<tr><td>Golden Eye</td><td>3.5</td></tr>\n" +
                "<tr><td>Short New</td><td>3.0</td></tr>\n" +
                "<tr><td>Long New</td><td>6.0</td></tr>\n" +
                "<tr><td>Bambi</td><td>1.5</td></tr>\n" +
                "<tr><td>Toy Story</td><td>3.0</td></tr>\n" +
                "</table>\n" +
                "<p>Amount owed is <em>19.0</em></p>\n" +
                "<p>You earned <em>7</em> frequent renter points</p>";

        assertThat(customer.htmlStatement()).isEqualTo(expected);
    }
}
