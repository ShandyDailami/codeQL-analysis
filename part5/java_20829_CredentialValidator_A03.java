public class java_20829_CredentialValidator_A03 {

    // Method to validate user credentials
    public boolean validate(String username, String password) {
        // Assume a simple authentication mechanism:
        // If both username and password are not null and they're not empty
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            // If the username is "admin" and the password is "password", allow the user
            if ("admin".equals(username) && "password".equals(password)) {
                return true;
            }
        // Otherwise, deny access
        } else {
            return false;
        }

        // If we got this far, there was an issue with either the username or password
        throw new RuntimeException("Validation failed");
    }
}