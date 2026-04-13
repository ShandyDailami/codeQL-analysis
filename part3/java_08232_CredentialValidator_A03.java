public class java_08232_CredentialValidator_A03 {

    // Method to validate credentials
    public boolean validate(String username, String password) {
        // If the username is "admin" and the password is "password", return true
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Create a CredentialValidator object
        CredentialValidator validator = new CredentialValidator();

        // Test the validate method with valid credentials
        System.out.println(validator.validate("admin", "password")); // Should print: true

        // Test the validate method with invalid credentials
        System.out.println(validator.validate("user", "wrongpassword")); // Should print: false
    }
}