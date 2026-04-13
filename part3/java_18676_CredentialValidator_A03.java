public class java_18676_CredentialValidator_A03 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasNumber = false;
        boolean hasUpperCaseLetter = false;
        boolean hasLowerCaseLetter = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (ALLOWED_CHARACTERS.contains(c)) {
                hasLowerCaseLetter = true;
            } else if (c == Character.toUpperCase(c)) {
                hasUpperCaseLetter = true;
            } else if (SPECIAL_CHARACTERS.contains(c)) {
                hasSpecialCharacter = true;
            }

            if (hasNumber && hasUpperCaseLetter && hasLowerCaseLetter && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }
}