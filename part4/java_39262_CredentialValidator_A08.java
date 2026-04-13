public class java_39262_CredentialValidator_A08 {

    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isAlphabetic(c) && !Character.isWhitespace(c)) {
                hasSpecialCharacter = true;
            }
        }

        return hasDigit && hasSpecialCharacter;
    }
}