public class java_07074_CredentialValidator_A07 {

    // Method to check if the password is strong
    public boolean isStrongPassword(String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Define the criteria for a strong password
        int minLength = 8;
        if (password.length() < minLength) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        // Iterate over each character in the password
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else {
                hasSpecialCharacter = true;
            }
        }

        // If the password is strong, return true
        return hasUpperCase && hasLowerCase && hasNumber && hasSpecialCharacter;
    }

}