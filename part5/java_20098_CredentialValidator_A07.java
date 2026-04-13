public class java_20098_CredentialValidator_A07 {
    private static final String VALID_USERNAME = "valid_user";
    private static final String VALID_PASSWORD = "valid_password";

    public boolean validate(String username, String password) {
        // Check if the username and password matches the predefined values
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            System.out.println("Credentials validated successfully.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        validator.validate("valid_user", "valid_password");  // Valid credentials
        validator.validate("invalid_user", "invalid_password");  // Invalid credentials
    }
}