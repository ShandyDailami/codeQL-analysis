import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_38656_CredentialValidator_A03 {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}$");

    public boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if(matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validatePassword(String password) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        if(matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateCredentials(String email, String password) {
        if(validateEmail(email) && validatePassword(password)) {
            return true;
        } else {
            return false;
        }
    }
}