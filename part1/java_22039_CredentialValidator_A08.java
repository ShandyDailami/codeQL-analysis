public class java_22039_CredentialValidator_A08 {

    // The method to check if the password meets the requirements
    public boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!isSpecialCharacter(c)) {
                hasSpecialCharacter = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }

    // Helper method to check if a character is a special character
    private boolean isSpecialCharacter(char c) {
        return !(c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']' || c == ';' || c == ':' || c == '.' || c == ',' || c == '<' || c == '>' || c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']' || c == ';' || c == ':' || c == '.' || c == ',' || c == '<' || c == '>' || c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*');
    }
}