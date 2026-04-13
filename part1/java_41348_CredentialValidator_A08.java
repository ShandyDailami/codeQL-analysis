public class java_41348_CredentialValidator_A08 {
    public static boolean isValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isAlphabetic(c)) {
                hasSpecialCharacter = true;
            }

            if (hasDigit && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }
}