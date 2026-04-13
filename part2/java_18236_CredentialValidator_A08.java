public class java_18236_CredentialValidator_A08 {

    // Verify if the password meets the criteria
    public boolean validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (!isValidSpecialCharacter(c)) {
                hasSpecialChar = true;
            }

            if (hasDigit && hasUpperCase && hasLowerCase && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    // Check if a character is a valid special character
    private boolean isValidSpecialCharacter(char c) {
        return !(c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']' || c == ';' || c == ':' || c == '.' || c == '!' || c == '?' || c == '<' || c == '>');
    }

}