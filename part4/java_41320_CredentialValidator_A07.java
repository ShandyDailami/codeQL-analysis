public class java_41320_CredentialValidator_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Testing
        validateCredentials("admin", "password");
        validateCredentials("admin", "wrongpassword");
        validateCredentials("wrongadmin", "password");
        validateCredentials("wrongadmin", "wrongpassword");
    }

    public static void validateCredentials(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}