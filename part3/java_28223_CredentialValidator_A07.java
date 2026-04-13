public class java_28223_CredentialValidator_A07 {
    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the credentials
    public static boolean validateCredentials(String username, String password) {
        // If the provided username and password match the predefined credentials
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true; // Credentials are valid
        } else {
            return false; // Credentials are invalid
        }
    }

    public static void main(String[] args) {
        // Validate the credentials
        boolean isValid = CredentialValidator.validateCredentials("admin", "password");

        // Print the result
        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}