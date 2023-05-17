package primitiveobsession;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    String swedishPersonalNumber = "19511111-7668";
    int role = UserRole.USER_ROLE_MANAGER;
    String phoneNumber = "00467123456";

    @Test
    void birthYear() {
        Person person = new Person(role, swedishPersonalNumber, phoneNumber);

        assertThat(person.getSwedishPersonalNumber().birthYear()).isEqualTo(1951);
    }

    @Test
    void countryCode() {
        Person person = new Person(role, swedishPersonalNumber, phoneNumber);

        assertThat(person.getPhoneNumber().countryCode()).isEqualTo("+46");
    }

    @Test
    void managersCanDeleteUsers() {
        Person person = new Person(role, swedishPersonalNumber, phoneNumber);

        assertThat(person.userRole.canDeleteUsers()).isTrue();
    }

    @Test
    void adminCanDeleteUsers() {
        Person person = new Person(UserRole.USER_ROLE_ADMIN, swedishPersonalNumber, phoneNumber);

        assertThat(person.userRole.canDeleteUsers()).isTrue();
    }

    @Test
    void salesCantDeleteUsers() {
        Person person = new Person(UserRole.USER_ROLE_SALES, swedishPersonalNumber, phoneNumber);

        assertThat(person.userRole.canDeleteUsers()).isFalse();
    }

    @Test
    void engineersCantDeleteUsers() {
        Person person = new Person(UserRole.USER_ROLE_ENGINEER, swedishPersonalNumber, phoneNumber);

        assertThat(person.userRole.canDeleteUsers()).isFalse();
    }

    @Test
    void standardizePhoneNumber() {
        Person person = new Person(role, swedishPersonalNumber, "+46123456");

        assertThat(person.getPhoneNumber().countryCode()).isEqualTo("+46");
    }

    @Test
    void standardizeLocalPhoneNumber() {
        Person person = new Person(role, swedishPersonalNumber, "0123456");

        assertThat(person.getPhoneNumber().countryCode()).isEmpty();
    }
}
