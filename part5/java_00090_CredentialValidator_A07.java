public class java_00090_CredentialValidator_A07 {
    // Method to validate credentials
    public boolean validate(String username, String password) {
        // Check if username is not null and password is not null
        if (username == null || password == null) {
            return false;
        }

        // Check if username is not empty and password is longer than 6 characters
        if (username.isEmpty() || password.length() <= 6) {
            return false;
        }

        // If everything is valid, return true
        return true;
    }

    public static void main(String[] args) {
        // Create a CredentialValidator instance
        CredentialValidator validator = new CredentialValidator();

        // Test the validate method
        System.out.println(validator.validate("test", "password")); // Expected output: true
        System.out.println(validator.validate("", "")); // Expected output: false
        System.out.println(validator.validate(null, null)); // Expected output: false
        System.out.println(validator.validate("test", "1234")); // Expected output: false
    }
}