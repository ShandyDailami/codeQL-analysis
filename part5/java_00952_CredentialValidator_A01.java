import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_00952_CredentialValidator_A01 {
    // Define a static constant for the minimum password length
    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    // Define a static constant for the maximum password length
    private static final int MAXIMUM_PASSWORD_LENGTH = 16;

    // Define a static constant for the password complexity requirements
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,16}$";

    // Define a static constant for the email complexity requirements
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    // Method to validate password
    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    // Method to validate email
    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}