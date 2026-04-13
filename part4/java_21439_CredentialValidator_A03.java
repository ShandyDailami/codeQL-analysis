public class java_21439_CredentialValidator_A03 {

    // Known username and password
    private final String knownUsername = "admin";
    private final String knownPassword = "password";

    // No constructor for testing purposes
    public java_21439_CredentialValidator_A03() { }

    // Method to validate a username and password
    public boolean validate(String username, String password) {
        // If the username and password match the known values, return true
        if (username.equals(knownUsername) && password.equals(knownPassword)) {
            return true;
        }
        // If not, return false
        else {
            return false;
        }
    }
}