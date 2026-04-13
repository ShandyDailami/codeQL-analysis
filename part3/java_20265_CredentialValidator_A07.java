public class java_20265_CredentialValidator_A07 {
    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    public boolean validateCredentials(String username, String password) {
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        boolean isValid = validator.validateCredentials("user", "password");
        if (isValid) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
}