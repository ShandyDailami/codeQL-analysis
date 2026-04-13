public class java_17180_CredentialValidator_A07 {
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public static boolean validate(String username, String password) {
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        if (validate("validUser", "validPassword")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}