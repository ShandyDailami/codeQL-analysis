public class java_04268_CredentialValidator_A03 {
    // Simple validation
    public boolean validate(String username, String password) {
        // Check if the password is not null and is at least 8 characters long
        if (password != null && password.length() >= 8) {
            // Check if the username is not null and is at least 4 characters long
            if (username != null && username.length() >= 4) {
                // If both conditions are met, return true
                return true;
            }
        }
        // If either condition is not met, return false
        return false;
    }
}