public class java_32550_CredentialValidator_A07 {

    public boolean validateCredentials(String username, String password) {
        // Step 1: Check if username and password are not empty
        if (username == null || password == null) {
            return false;
        }

        // Step 2: Check if username and password are the same as in the legacy code
        if (!username.equals("user") || !password.equals("password")) {
            return false;
        }

        // Step 3: Check if the password is at least 8 characters long and contains at least one uppercase, lowercase, digit, and special character
        if (!(password.length() >= 8 && containsDigit(password) && containsUpperCase(password) && containsLowerCase(password) && containsSpecialChar(password))) {
            return false;
        }

        // Step 4: Check if the username is a valid email
        if (!isValidEmail(username)) {
            return false;
        }

        // Step 5: If all checks pass, return true
        return true;
    }

    private boolean containsDigit(String str) {
        // Implement your method here
    }

    private boolean containsUpperCase(String str) {
        // Implement your method here
    }

    private boolean containsLowerCase(String str) {
        // Implement your method here
    }

    private boolean containsSpecialChar(String str) {
        // Implement your method here
    }

    private boolean isValidEmail(String email) {
        // Implement your method here
    }
}