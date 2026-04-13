public class java_08360_CredentialValidator_A08 {

    // Method to check if the password is strong enough
    public static boolean isPasswordStrong(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Iterate through each character in the password
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            // Check for uppercase letter
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }

            // Check for lowercase letter
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }

            // Check for digit
            if (Character.isDigit(c)) {
                hasDigit = true;
            }

            // Check for special character
            if (!(c == ' ')) {
                hasSpecialChar = true;
            }

            // Check if all conditions are met
            if (hasLowerCase && hasUpperCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }
}