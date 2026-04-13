public class java_30101_CredentialValidator_A01 {
    private static final String ALLOWED_USERNAME = "admin";
    private static final String ALLOWED_PASSWORD = "password";

    public static boolean validate(String username, String password) {
        if (username.equals(ALLOWED_USERNAME) && password.equals(ALLOWED_PASSWORD)) {
            System.out.println("Access granted!");
            return true;
        } else {
            System.out.println("Access denied!");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validation
        validate("admin", "password");
        validate("wrongUser", "wrongPassword");
        validate("admin", "wrongPassword");
    }
}