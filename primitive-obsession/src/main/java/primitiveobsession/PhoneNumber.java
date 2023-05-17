package primitiveobsession;

public class PhoneNumber {

    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String countryCode() {
        String code = "";
        if (number.startsWith("00"))
            code = number.substring(2, 4);
        else if (number.startsWith("+")) {
            code = number.substring(1, 3);
        }
        if (!code.isEmpty())
            return "+" + code;
        return "";
    }
}
