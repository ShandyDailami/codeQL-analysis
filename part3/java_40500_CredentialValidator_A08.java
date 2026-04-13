import java.util.Base64;

public class java_40500_CredentialValidator_A08 {

    // Stored hard-coded username and password
    private static final String HARD_CODED_USERNAME = "admin";
    private static final String HARD_CODED_PASSWORD = "password";

    // Function to verify user credentials
    public static boolean validateCredentials(String username, String password) {
        // Encode the hard-coded credentials
        String hardCodedCredentials = HARD_CODED_USERNAME + ":" + HARD_CODED_PASSWORD;
        String encodedCredentials = Base64.getEncoder().encodeToString(hardCodedCredentials.getBytes());

        // Check if the received credentials match the hard-coded credentials
        if (encodedCredentials.equals(Base64.getEncoder().encodeToString(password.getBytes()))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validateCredentials method
        System.out.println(validateCredentials("admin", "password"));  // Should print: true
        System.out.println(validateCredentials("wrong_username", "password"));  // Should print: false
        System.out.println(validateCredentials("admin", "wrong_password"));  // Should print: false
    }
}