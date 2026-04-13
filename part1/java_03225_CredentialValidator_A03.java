public class java_03225_CredentialValidator_A03 {

    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // The method that validates the credentials
    public static boolean validateCredentials(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Test the validator
        boolean isValid = validateCredentials("admin", "password");
        System.out.println("Is valid: " + isValid);
    }
}