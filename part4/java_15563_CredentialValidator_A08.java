public class java_15563_CredentialValidator_A08 {

    // Hardcoded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        validate("admin", "password");
        validate("wrongUsername", "wrongPassword");
    }

    public static void validate(String username, String password) {
        // If the given credentials match the hardcoded credentials, print a success message
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}