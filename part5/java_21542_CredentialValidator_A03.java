import java.util.regex.Pattern;

public class java_21542_CredentialValidator_A03 {

    // Pattern for email validation
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }
        return VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches();
    }

    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }
        // Assuming password strength check here. In reality, you would have a check against
        // common passwords and brute force methods.
        return password.length() >= 8;
    }

    public boolean validateUsername(String username) {
        if (username == null) {
            return false;
        }
        // Assuming username validation here. In reality, you would have a check against
        // common usernames and brute force methods.
        return !username.equals("admin");
    }
}