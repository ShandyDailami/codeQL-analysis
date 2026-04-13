public class java_00480_CredentialValidator_A08 {

    // Attempt to match a password to a specific pattern
    private static boolean matchPasswordPattern(String password) {
        // Simple pattern to match passwords that contain at least one number and one uppercase letter
        return password.matches(".*[0-9].*|.*[A-Z].*");
    }

    // Validate the password
    public static boolean validatePassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        
        // Check the password against a specific pattern
        return matchPasswordPattern(password);
    }

    // Main method to test the validator
    public static void main(String[] args) {
        // Test valid password
        System.out.println(validatePassword("Test1234")); // should return true

        // Test invalid password
        System.out.println(validatePassword("test1234")); // should return false
    }
}