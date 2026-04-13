import java.util.Base64;

public class java_13568_CredentialValidator_A08 {

    // In a real world application, these should be encrypted
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password";

    public boolean isValid(String username, String password) {
        // First, encode the username and password to Base64
        String encodedUsername = Base64.getEncoder().encodeToString(username.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Then, compare them with the expected values
        return encodedUsername.equals(CORRECT_USERNAME) && encodedPassword.equals(CORRECT_PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try to authenticate with the correct credentials
        if (validator.isValid("admin", "password")) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}