public class java_30034_CredentialValidator_A07 {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public static boolean validate(String username, String password) {
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            System.out.println("Credentials validated successfully.");
            return true;
        } else {
            System.out.println("Credentials invalid.");
            return false;
        }
    }

    public static void main(String[] args) {
        // Validate credentials
        boolean isValid = validate("admin", "password");

        // Print result
        if (isValid) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}