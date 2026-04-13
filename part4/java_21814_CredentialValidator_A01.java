public class java_21814_CredentialValidator_A01 {

    public static boolean validatePassword(String password) {
        if (password == null || password.length() == 0) {
            return false;
        }

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
            } else if (!isValidSpecialCharacter(c)) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValidSpecialCharacter(char c) {
        // This method can be extended to include more special characters if needed.
        return c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*';
    }
}