public class java_29964_CredentialValidator_A08 {
    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (!isValidSpecialCharacter(c)) {
                hasSpecialChar = true;
            }
            if (hasDigit && hasUppercase && hasSpecialChar) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidSpecialCharacter(char c) {
        return !(Character.isLetter(c) || Character.isDigit(c) || Character.isSpaceChar(c));
    }
}