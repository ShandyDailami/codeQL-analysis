public class java_16895_CredentialValidator_A03 {

    // Hardcoded user and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // No constructor to prevent instantiation of class
    private java_16895_CredentialValidator_A03() {}

    public static boolean validateCredentials(String inputUsername, String inputPassword) {
        // If input fields are null or empty, return false
        if (inputUsername == null || inputPassword == null || inputUsername.isEmpty() || inputPassword.isEmpty()) {
            return false;
        }

        // If input fields do not match hardcoded values, return false
        if (!inputUsername.equals(USERNAME) || !inputPassword.equals(PASSWORD)) {
            return false;
        }

        // If no exceptions were thrown, input is correct, so return true
        return true;
    }
}