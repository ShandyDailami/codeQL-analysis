public class java_10335_CredentialValidator_A01 {
    private String username = "admin";
    private String password = "password";

    // Constructor
    public java_10335_CredentialValidator_A01() {}

    // Method to validate username and password
    public boolean validate(String enteredUsername, String enteredPassword) {
        if (enteredUsername != null && enteredUsername.equals(username)
                && enteredPassword != null && enteredPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Valid username and password
        System.out.println(validator.validate("admin", "password")); // Should print true

        // Invalid username and password
        System.out.println(validator.validate("user", "wrongpassword")); // Should print false
    }
}