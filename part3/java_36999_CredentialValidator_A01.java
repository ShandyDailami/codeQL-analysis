public class java_36999_CredentialValidator_A01 {
    public static boolean validateCredentials(String username, String password) {
        // Simplified version: Uses a fixed username and password
        // You should consider using a more secure method for storing passwords
        String correctUsername = "admin";
        String correctPassword = "password";

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}