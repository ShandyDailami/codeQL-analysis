public class java_15379_CredentialValidator_A08 {

    // Predefined credentials
    private String username = "admin";
    private String password = "password";

    public boolean validate(String inputUsername, String inputPassword) {
        // Check if the provided credentials match the predefined ones
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            return true; // Credentials match
        } else {
            return false; // Credentials do not match
        }
    }
}