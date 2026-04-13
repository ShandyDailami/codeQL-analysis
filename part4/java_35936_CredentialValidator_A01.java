public class java_35936_CredentialValidator_A01 {

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        boolean hasUpperCaseLetter = false;
        boolean hasLowerCaseLetter = false;

        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCaseLetter = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCaseLetter = true;
            } else if (!isValidSpecialCharacter(c)) {
                hasSpecialChar = true;
            }

            if (hasDigit && hasUpperCaseLetter && hasLowerCaseLetter && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    private boolean isValidSpecialCharacter(char c) {
        return (c >= '\u0020' && c <= '\u002F') ||
                (c >= '\u003A' && c <= '\u0040') ||
                (c >= '\u005B' && c <= '\u0060') ||
                (c >= '\u007B' && c <= '\u007E');
    }
}