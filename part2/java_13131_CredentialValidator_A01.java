public class java_13131_CredentialValidator_A01 {

    // Method to validate password
    public boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        boolean hasUpperCase = false;

        // Check for each character
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(ch) != -1) {
                hasSpecialChar = true;
            }
        }

        // If all conditions met, password is valid
        return hasDigit && hasUpperCase && hasSpecialChar;
    }
}