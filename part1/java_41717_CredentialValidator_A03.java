public class java_41717_CredentialValidator_A03 {

    // Define predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the username and password
    public static boolean validate(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Credentials validated successfully.");
            return true;
        } else {
            System.out.println("Credentials invalid.");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test with valid credentials
        validate("admin", "password");

        // Test with invalid credentials
        validate("admin", "wrongpassword");
    }
}