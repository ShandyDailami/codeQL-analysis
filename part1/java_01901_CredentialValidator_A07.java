public class java_01901_CredentialValidator_A07 {

    // Hard-coded password
    private static final String hardCodedPassword = "password";

    // Method to validate password
    public boolean validate(String enteredPassword) {
        return enteredPassword.equals(hardCodedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Example usage
        if (validator.validate("wrongPassword")) {
            System.out.println("Invalid password");
        } else {
            System.out.println("Access granted");
        }
    }
}