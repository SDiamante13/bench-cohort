package primitiveobsession;

public class Person {

    public static final int USER_ROLE_ADMIN = 0;
    public static final int USER_ROLE_ENGINEER = 1;
    public static final int USER_ROLE_MANAGER = 2;
    public static final int USER_ROLE_SALES = 3;

    private int role;
    private PersonalNumber swedishPersonalNumber;
    private PhoneNumber phoneNumber;

    public Person(int role, String swedishPersonalNumber, String phoneNumber) {
        setRole(role);
        setSwedishPersonalNumber(swedishPersonalNumber);
        this.setPhoneNumber(phoneNumber);
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        if (role < 0 || role > 4)
            throw new IllegalArgumentException("illegal role" + role);
        this.role = role;
    }

    public PersonalNumber getSwedishPersonalNumber() {
        return swedishPersonalNumber;
    }

    public void setSwedishPersonalNumber(String swedishPersonalNumber) {
        swedishPersonalNumber = swedishPersonalNumber.replace("-", "");
        if (swedishPersonalNumber.length() != 12)
            throw new IllegalArgumentException("invalid personal number " + swedishPersonalNumber);
        this.swedishPersonalNumber = new PersonalNumber(swedishPersonalNumber);
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = new PhoneNumber(phoneNumber);
    }

    public boolean canDeleteUsers() {
        return this.role == Person.USER_ROLE_MANAGER || this.role == Person.USER_ROLE_ADMIN;
    }
}
