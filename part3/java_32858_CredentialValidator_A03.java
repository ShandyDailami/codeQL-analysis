public class java_32858_CredentialValidator_A03 {

    // Method to validate the password
    public boolean validatePassword(String password) {
        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;

        // Checking the password for each character
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(c) != -1) {
                hasSpecialChar = true;
            }
            if (hasDigit && hasUpperCase && hasLowerCase && hasSpecialChar) {
                return true;
            }
        }
        return false;
    }
}