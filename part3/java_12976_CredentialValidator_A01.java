public class java_12976_CredentialValidator_A01 {

    // Predefined set of credentials.
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // Check if the given username and password match the predefined ones.
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Test the credential validator.
        System.out.println(validate("admin", "password")); // Should print true.
        System.out.println(validate("user", "wrongpassword")); // Should print false.
    }
}