public class java_03537_CredentialValidator_A01 {

    public static boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (!isValidSpecialCharacter(c)) {
                hasSpecialChar = true;
            }
            if (hasDigit && hasUpperCase && hasSpecialChar) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidSpecialCharacter(char c) {
        return c != '{' && c != '[' && c != '(' && c != '<' && c != '!' && c != '|' && c != '~';
    }
}