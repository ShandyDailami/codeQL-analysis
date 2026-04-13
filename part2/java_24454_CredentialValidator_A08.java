public class java_24454_CredentialValidator_A08 {

    // Method to check if password is strong
    public boolean isStrongPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one digit
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                break;
            }
        }

        // Check if password contains at least one uppercase letter
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
                break;
            }
        }

        // Check if password contains at least one special character
        String specialChars = "!@#$%^&*()_+=-[]{};:'\",.<>?/\\|`~";
        for (char c : password.toCharArray()) {
            if (specialChars.contains(String.valueOf(c))) {
                hasSpecialChar = true;
                break;
            }
        }

        return hasDigit && hasUpperCase && hasSpecialChar;
    }
}