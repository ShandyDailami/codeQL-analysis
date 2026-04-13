public class java_28524_CredentialValidator_A08 {

    public static boolean isPasswordStrong(String password) {
        // Check password length
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Check if password contains uppercase letter, lowercase letter, digit, and special character
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }

            // If all checks are done, break the loop
            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                break;
            }
        }

        // Return if all checks are passed
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    public static void main(String[] args) {
        String password = "My@123Password";
        System.out.println(isPasswordStrong(password));
    }
}