import java.util.Base64;

public class java_22383_CredentialValidator_A07 {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public boolean validate(String username, String password) {
        // Check if the provided username and password match the expected values
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        try {
            validator.validate("admin", "password"); // This should work
            validator.validate("wrongusername", "wrongpassword"); // This should throw an AuthenticationException
        } catch (javax.security.auth.AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }
}