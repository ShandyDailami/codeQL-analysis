import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_20461_CredentialValidator_A01 {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public boolean validatePassword(String password) {
        return password.length() >= 8;
    }

    public boolean validateUsername(String username) {
        return !username.isEmpty();
    }

    public boolean validateCredentials(String email, String password, String username) {
        return validateEmail(email) && validatePassword(password) && validateUsername(username);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateCredentials("test@email.com", "password", "username"));
    }
}