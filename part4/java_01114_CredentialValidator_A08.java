public class java_01114_CredentialValidator_A08 {

    // Method to check if password is valid
    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean digit = false;
        boolean lowercase = false;
        boolean uppercase = false;
        boolean special = false;

        // Check each character in the password
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            // Check for digit
            if (Character.isDigit(ch)) {
                digit = true;
            }

            // Check for lowercase letter
            if (Character.isLowerCase(ch)) {
                lowercase = true;
            }

            // Check for uppercase letter
            if (Character.isUpperCase(ch)) {
                uppercase = true;
           
            // Check for special character
            if (!(ch == ' ' || Character.isLetterOrDigit(ch))) {
                special = true;
            }
        }

        // Return if password is valid
        return digit && lowercase && uppercase && special;
    }
}