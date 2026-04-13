public class java_41890_CredentialValidator_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false; // Invalid input
        }
        if (!username.equals(USERNAME)) {
            return false; // Invalid username
        }
        if (!password.equals(PASSWORD)) {
            return false; // Invalid password
        }
        return true; // Valid credentials
    }
}