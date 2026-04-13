public class java_31485_CredentialValidator_A07 {

    // Predefined username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}