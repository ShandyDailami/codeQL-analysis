public class java_10850_CredentialValidator_A07 {

    // The main validation method
    public boolean validatePassword(String password) {
        // Return false if password is null
        if (password == null) {
            return false;
        }

        // Return false if password is too short
        if (password.length() < 8) {
            return false;
        }

        // Initialize a flag to indicate whether a lowercase letter was found
        boolean hasLowerCase = false;
        // Initialize a flag to indicate whether an uppercase letter was found
        boolean hasUpperCase = false;
        // Initialize a flag to indicate whether a digit was found
        boolean hasDigit = false;

        // Check each character in the password
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            // If a lowercase letter was found, set the flag
            if ('a' <= c && c <= 'z') {
                hasLowerCase = true;
            }
            // If an uppercase letter was found, set the flag
            if ('A' <= c && c <= 'Z') {
                hasUpperCase = true;
            }
            // If a digit was found, set the flag
            if ('0' <= c && c <= '9') {
                hasDigit = true;
            }
        }

        // Return true if all the flags were set to true
        return hasLowerCase && hasUpperCase && hasDigit;
    }
}