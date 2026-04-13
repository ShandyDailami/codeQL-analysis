public class java_31963_CredentialValidator_A03 {

    // Hardcoded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // The method that validates the username and password
    public static boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Test the validate method
        System.out.println(validate("admin", "password")); // Output: true
        System.out.println(validate("user", "wrongpassword")); // Output: false
    }
}