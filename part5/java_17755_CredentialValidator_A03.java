public class java_17755_CredentialValidator_A03 {

    // Simulate hard-coded credentials
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // Check if the username and password match the expected values
        if (username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD)) {
            System.out.println("Credentials are valid!");
            return true;
        } else {
            System.out.println("Credentials are not valid.");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test with valid credentials
        validate("admin", "password");

        // Test with invalid credentials
        validate("wrong", "wrong");
    }
}