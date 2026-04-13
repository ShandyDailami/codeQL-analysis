public class java_31565_CredentialValidator_A03 {

    // Define a predefined set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate username and password
    public boolean validate(String username, String password) {
        if (username != null && password != null) {
            if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                return true;
            }
        }
        return false;
    }

}