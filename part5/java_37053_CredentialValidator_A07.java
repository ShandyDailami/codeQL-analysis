public class java_37053_CredentialValidator_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Example of authenticating a user
        if (authenticate("admin", "password")) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
    }

    private static boolean authenticate(String username, String password) {
        // Check if the provided username and password match the expected ones
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}