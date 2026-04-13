public class java_23076_CredentialValidator_A08 {
    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (!isValid(ch)) {
                hasSpecialChar = true;
            }

            if (hasDigit && hasUpperCase && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValid(char ch) {
        return (ch == '_' || ch == '~' || ch == '@' || ch == '*' || ch == '+' || ch == '-' || ch == '=' || ch == '.' || ch == '/');
    }
}