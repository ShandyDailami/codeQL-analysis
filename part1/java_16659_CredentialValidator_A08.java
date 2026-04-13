public class java_16659_CredentialValidator_A08 {

    // The predefined password
    private static final String PREDETERMINED_PASSWORD = "secret";

    // Method to validate the password
    public boolean validatePassword(String password) {
        return password.equals(PREDETERMINED_PASSWORD);
    }

    // Main method to test the credential validator
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validatePassword("wrongPassword");
        if (isValid) {
            System.out.println("Valid password provided.");
        } else {
            System.out.println("Invalid password provided.");
        }
    }
}