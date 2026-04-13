public class java_19694_CredentialValidator_A07 {
    public boolean validate(String username, String password) {
        // Check if username and password is not null
        if (username == null || password == null) {
            return false;
        }

        // Check if username is long enough
        if (username.length() < 5) {
            return false;
        }

        // Check if password is long enough
        if (password.length() < 8) {
            return false;
        }

        // If all checks passed, return true
        return true;
    }
}