import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_25356_CredentialValidator_A03 {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validatePassword(String password) {
        if (password.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\d{3}-\\d{4}-\\d{4}")) {
            return true;
        } else if (phoneNumber.matches("\\d{10}")) {
            return true;
        } else {
            return false;
        }
    }
}