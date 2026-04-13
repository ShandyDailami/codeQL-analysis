public class java_13460_CredentialValidator_A01 {
    // Hardcoded username and password
    private static final String hardcodedUsername = "admin";
    private static final String hardcodedPassword = "password";

    // Method to validate credentials
    public static boolean validate(String username, String password) {
        return username.equals(hardcodedUsername) && password.equals(hardcodedPassword);
    }

    public static void main(String[] args) {
        // Testing the validate method
        System.out.println(validate("admin", "password")); // Expected to return true
        System.out.println(validate("wrongusername", "password")); // Expected to return false
        System.out.println(validate("admin", "wrongpassword")); // Expected to return false
    }
}