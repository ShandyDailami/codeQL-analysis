public class java_34029_CredentialValidator_A07 {

    // Predefined credentials.
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validateCredentials(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String providedUsername = "admin";
        String providedPassword = "password";

        if (validateCredentials(providedUsername, providedPassword)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}