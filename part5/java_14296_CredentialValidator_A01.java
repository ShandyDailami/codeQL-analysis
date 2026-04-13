// CredentialValidator example program for A01_BrokenAccessControl

import java.util.Base64;
import java.util.regex.Pattern;

public class java_14296_CredentialValidator_A01 {

    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9_]{3,}$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

    public boolean validateCredentials(String username, String password) {
        // Validate username
        if (!VALID_USERNAME_PATTERN.matcher(username).matches()) {
            return false;
        }

        // Validate password
        if (!VALID_PASSWORD_PATTERN.matcher(password).matches()) {
            return false;
        }

        // Assume that password is already encoded in Base64
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String username = "admin";
        String password = "$uper$ecret";
        boolean isValid = validator.validateCredentials(username, password);
        System.out.println("Is valid: " + isValid);
    }
}