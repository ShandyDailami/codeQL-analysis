public class java_41347_CredentialValidator_A03 {
    // Hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate a username and password
    public static boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Test the validator
        boolean valid = validate("admin", "password");
        if (valid) {
            System.out.println("Validated successfully!");
        } else {
            System.out.println("Failed to validate!");
        }
    }
}