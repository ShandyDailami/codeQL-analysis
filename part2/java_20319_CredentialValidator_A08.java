public class java_20319_CredentialValidator_A08 {
    // Hard-coded passwords
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // Check if the entered username and password match
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Authentication successful!");
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validate method
        validate("admin", "password"); // This should print "Authentication successful!" and return true
        validate("wrong", "username"); // This should print "Invalid username or password" and return false
    }
}