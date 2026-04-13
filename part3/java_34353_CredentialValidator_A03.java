public class java_34353_CredentialValidator_A03 {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    // Method to validate username and password
    public boolean validateCredentials(String username, String password) {
        if (username != null && username.equals(VALID_USERNAME) 
            && password != null && password.equals(VALID_PASSWORD)) {
            return true;
        }
        return false;
    }

    // Method to authenticate user
    public void authenticateUser(String username, String password) {
        if (!validateCredentials(username, password)) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        // Authentication successful, go ahead and perform actions
        System.out.println("Authentication successful!");
    }
}