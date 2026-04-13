public class java_33840_CredentialValidator_A01 {

    // This is the main method
    public static void main(String[] args) {
        // Test the CredentialValidator
        System.out.println(validateCredentials("test", "password"));
    }

    // Method to validate credentials
    public static boolean validateCredentials(String username, String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password length is greater than 6
        if (password.length() <= 6) {
            return false;
        }

        // Check if password contains a digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }
}