public class java_14932_CredentialValidator_A07 {

    // Define a hardcoded user and password
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        
        // Test with valid credentials
        if (validator.validateCredentials("user", "pass")) {
            System.out.println("Credentials are valid");
        } else {
            System.out.println("Invalid credentials");
        }
        
        // Test with invalid credentials
        if (validator.validateCredentials("wrongUser", "wrongPass")) {
            System.out.println("Invalid credentials");
        } else {
            System.out.println("Credentials are valid");
        }
    }
}