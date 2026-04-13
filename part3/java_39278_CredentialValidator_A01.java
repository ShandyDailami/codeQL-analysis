public class java_39278_CredentialValidator_A01 {

    // A simple username and password for this example
    private String validUsername = "admin";
    private String validPassword = "password";

    // Method to validate the username and password
    public boolean validate(String username, String password) {
        if (username != null && password != null) {
            // Check if the provided username and password matches the valid ones
            if (username.equals(validUsername) && password.equals(validPassword)) {
                return true;
            }
        }
        return false;
    }

}