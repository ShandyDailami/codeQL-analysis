public class java_08762_CredentialValidator_A01 {

    // Field to store the correct username and password
    private String correctUsername = "admin";
    private String correctPassword = "password";

    // Method to validate the given username and password
    public boolean validate(String username, String password) {
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true; // Authentication successful
        } else {
            return false; // Authentication failed
        }
    }
}