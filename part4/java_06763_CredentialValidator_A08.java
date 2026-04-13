public class java_06763_CredentialValidator_A08 {

    // Hardcoded username and password
    private static final String HARDCODED_USERNAME = "admin";
    private static final String HARDCODED_PASSWORD = "password";

    public boolean validate(String username, String password) {
        // If the provided username and password match the hardcoded ones, return true
        if (username.equals(HARDCODED_USERNAME) && password.equals(HARDCODED_PASSWORD)) {
            return true;
        }
        // If the provided username and password don't match the hardcoded ones, return false
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        // Test with valid credentials
        if (validator.validate("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
        // Test with invalid credentials
        if (validator.validate("invalid", "invalid")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}