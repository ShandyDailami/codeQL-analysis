public class java_14031_CredentialValidator_A07 {
    private String expectedUsername = "admin";
    private String expectedPassword = "password";

    public boolean validate(String username, String password) {
        // Check if usernames and passwords match
        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            System.out.println("Authentication successful!");
            return true;
        } else {
            System.out.println("Authentication failed!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        validator.validate("admin", "password");

        // Test invalid credentials
        validator.validate("invalid", "invalid");
    }
}