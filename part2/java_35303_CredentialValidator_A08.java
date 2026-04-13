public class java_35303_CredentialValidator_A08 {

    // Hard-coded password
    private static final String HARD_CODED_PASSWORD = "password";

    // Method for validating credentials
    public boolean validateCredentials(String providedPassword) {
        return HARD_CODED_PASSWORD.equals(providedPassword);
    }

    // Driver method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // You can change the password as you want
        String providedPassword = "newPassword";

        // Validate the password
        if (validator.validateCredentials(providedPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}