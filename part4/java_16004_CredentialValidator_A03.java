public class java_16004_CredentialValidator_A03 {
    // private fields for username and password
    private String username;
    private String password;

    // constructor
    public java_16004_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // method to validate username and password
    public boolean validateCredentials() {
        // check if username is null or empty
        if (username == null || username.isEmpty()) {
            return false;
        }
        // check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }
        // check if password is long enough
        if (password.length() < 8) {
            return false;
        }
        // check if password contains at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }
        // check if password contains at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }
        // check if password contains at least one uppercase character
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        // check if password contains at least one lowercase character
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        // if all checks pass, return true
        return true;
    }
}