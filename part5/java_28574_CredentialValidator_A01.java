public class java_28574_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!(containsUpperCase(password) && containsLowerCase(password) && containsNumber(password) && containsSpecialCharacter(password))) {
            return false;
        }

        return true;
    }

    private boolean containsUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (UPPERCASE.contains(c + "")) {
                return true;
            }
        }
        return false;
    }

    private boolean containsLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (LOWERCASE.contains(c + "")) {
                return true;
            }
        }
        return false;
    }

    private boolean containsNumber(String password) {
        for (char c : password.toCharArray()) {
            if (NUMBERS.contains(c + "")) {
                return true;
            }
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.contains(c + "")) {
                return true;
            }
        }
        return false;
    }
}