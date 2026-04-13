public class java_28427_CredentialValidator_A07 {

    // Expected values
    private final String expectedUsername = "admin";
    private final String expectedPassword = "password";

    public boolean validate(String username, String password) {
        // If both values match expected values
        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            System.out.println("Authentication successful.");
            return true;
        } else {
            System.out.println("Authentication failed.");
            return false;
        }
    }
}