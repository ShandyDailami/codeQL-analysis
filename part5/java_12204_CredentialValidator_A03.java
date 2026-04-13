public class java_12204_CredentialValidator_A03 {
    // Constants for special characters
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+=-[]{};':\",.<>?/\\|`~";

    public boolean validateCredentials(String username, String password) {
        // Check if password has at least one uppercase letter, one lowercase letter, one number, and one special character
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false, hasLowerCase = false, hasNumber = false, hasSpecialCharacter = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                hasSpecialCharacter = true;
            }

            if (hasUpperCase && hasLowerCase && hasNumber && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }
}