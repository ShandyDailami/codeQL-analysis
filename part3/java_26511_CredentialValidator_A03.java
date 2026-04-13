public class java_26511_CredentialValidator_A03 {
    // Predefined set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean isValid(String username, String password) {
        // Check if the provided username and password match the predefined set
        if (username != null && username.equals(USERNAME) && password != null && password.equals(PASSWORD)) {
            System.out.println("Credentials are valid.");
            return true;
        } else {
            System.out.println("Credentials are invalid.");
            return false;
        }
    }
}