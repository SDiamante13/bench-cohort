package primitiveobsession;

public class Person {



    UserRole userRole;
    private PersonalNumber swedishPersonalNumber;
    private PhoneNumber phoneNumber;

    public Person(int role, String swedishPersonalNumber, String phoneNumber) {
        setRole(role);
        setSwedishPersonalNumber(swedishPersonalNumber);
        this.setPhoneNumber(phoneNumber);
    }

    public UserRole getRole() {
        return this.userRole;
    }

    public void setRole(int role) {
        if (role < 0 || role > 4)
            throw new IllegalArgumentException("illegal role" + role);
        this.userRole = new UserRole(role);
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

}
