public class java_08742_CredentialValidator_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validateCredentials(String enteredUsername, String enteredPassword) {
        if (enteredUsername.equals(USERNAME) && enteredPassword.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        String enteredUsername = "admin";
        String enteredPassword = "password";

        if (validateCredentials(enteredUsername, enteredPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}