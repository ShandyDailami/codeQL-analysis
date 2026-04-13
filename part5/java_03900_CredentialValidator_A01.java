public class java_03900_CredentialValidator_A01 {
    // These are just placeholders, the actual values will be set by the user
    private String validUsername = "admin";
    private String validPassword = "password";

    public boolean validate(String username, String password) {
        // Check if the given username and password match the expected values
        if (username.equals(validUsername) && password.equals(validPassword)) {
            return true;
        } else {
            return false;
        }
    }
}