public class java_12302_CredentialValidator_A08 {

    private static final String HARD_CODED_PASSWORD = "1234"; // hard-coded password

    // Method to validate the password
    public boolean validatePassword(String password) {
        if (password != null && password.equals(HARD_CODED_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        
        // Check if password is valid
        boolean isValid = validator.validatePassword("1234");

        if (isValid) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}