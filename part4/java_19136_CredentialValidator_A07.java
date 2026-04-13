public class java_19136_CredentialValidator_A07 {
    // Define a constant for the predefined username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the username and password
    public boolean validate(String user, String pass) {
        if (user != null && user.equals(USERNAME) && pass != null && pass.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}