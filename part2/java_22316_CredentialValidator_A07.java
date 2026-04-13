public class java_22316_CredentialValidator_A07 {
    public static boolean validateCredentials(String username, String password) {
        // Hardcoded values
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        // Check if the given credentials match the hardcoded values
        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validateCredentials method
        System.out.println(validateCredentials("admin", "password")); // Should print true
        System.out.println(validateCredentials("wrongUsername", "wrongPassword")); // Should print false
    }
}