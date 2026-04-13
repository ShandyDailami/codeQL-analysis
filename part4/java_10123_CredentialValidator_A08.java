public class java_10123_CredentialValidator_A08 {
    // Hardcoded password
    private static final String DATABASE_PASSWORD = "securePassword";

    // Method to validate password
    public boolean validatePassword(String password) {
        return password.equals(DATABASE_PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing
        String testPassword = "wrongPassword";
        boolean isValid = validator.validatePassword(testPassword);

        if (isValid) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}