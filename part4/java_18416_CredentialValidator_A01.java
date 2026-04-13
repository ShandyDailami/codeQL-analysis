public class java_18416_CredentialValidator_A01 {

    // Hardcoded username and password
    private static final String HARDCODED_USERNAME = "admin";
    private static final String HARDCODED_PASSWORD = "password";

    public static void main(String[] args) {
        // Username and password to be entered by user
        String enteredUsername = "admin";
        String enteredPassword = "password";

        // Validate the credentials
        if (validateCredentials(enteredUsername, enteredPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    private static boolean validateCredentials(String username, String password) {
        // If the entered username and password match the hardcoded credentials, return true
        if (username.equals(HARDCODED_USERNAME) && password.equals(HARDCODED_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}