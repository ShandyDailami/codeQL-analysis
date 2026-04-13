public class java_35805_CredentialValidator_A08 {

    // A hardcoded set of credentials
    private static String hardcodedUsername = "admin";
    private static String hardcodedPassword = "password";

    // Validate credentials
    public static boolean validateCredentials(String username, String password) {
        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method to test the CredentialValidator
    public static void main(String[] args) {
        String username = "admin";
        String password = "password";

        if (validateCredentials(username, password)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}