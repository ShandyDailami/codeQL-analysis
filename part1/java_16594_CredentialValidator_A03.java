public class java_16594_CredentialValidator_A03 {

    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasLowerCase = false, hasUpperCase = false, hasDigit = false, hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!isValidSpecialCharacter(c)) {
                hasSpecialChar = true;
            }

            if (hasLowerCase && hasUpperCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    private boolean isValidSpecialCharacter(char c) {
        return c != '(' && c != ')' && c != '{' && c != '}' && c != '[' && c != ']' && c != '<' && c != '>' && c != '?' && c != '!' && c != '@' && c != '#' && c != '$' && c != '%' && c != '^' && c != '&' && c != '*' && c != '(' && c != ')';
    }
}