public class java_08849_CredentialValidator_A08 {
    // Fields
    private String expectedPassword;

    // Constructor
    public java_08849_CredentialValidator_A08(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    // Method to validate the password
    public boolean isPasswordValid(String providedPassword) {
        // The providedPassword is null or empty.
        if (providedPassword == null || providedPassword.isEmpty()) {
            return false;
        }

        // Compare the providedPassword with the expectedPassword.
        // In a real application, you should use a more secure method to compare passwords.
        // For simplicity, we compare the passwords directly.
        return providedPassword.equals(this.expectedPassword);
    }

    // Main method for testing
    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator("testPassword");

        // Test with correct password
        if (validator.isPasswordValid("testPassword")) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }

        // Test with incorrect password
        if (validator.isPasswordValid("incorrectPassword")) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}