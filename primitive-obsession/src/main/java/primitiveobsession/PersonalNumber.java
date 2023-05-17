package primitiveobsession;

public class PersonalNumber {
    private String number;

    public PersonalNumber(String number) {
        this.number = number;
    }

    public int birthYear() {
        String year = number.substring(0, 4);
        return Integer.parseInt(year);
    }
}
