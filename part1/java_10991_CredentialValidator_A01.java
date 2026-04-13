public class java_10991_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String SPECIAL_CHARACTERS_SET = new HashSet<>(Arrays.asList(SPECIAL_CHARACTERS.split("")));
    private static final String NUMBERS = "0123456789";

    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        if (!hasUpperCase(password)) {
            return false;
        }
        if (!hasLowerCase(password)) {
            return false;
        }
        if (!hasNumber(password)) {
            return false;
        }
        if (!hasSpecialCharacter(password)) {
            return false;
        }
        return true;
    }

    private boolean hasUpperCase(String password) {
        return password.regionMatches(true, 0, "(?=.*[A-Z])", 0, password.length());
    }

    private boolean hasLowerCase(String password) {
        return password.regionMatches(true, 0, "(?=.*[a-z])", 0, password.length());
    }

    private boolean hasNumber(String password) {
        return password.regionMatches(true, 0, "(?=.*[0-9])", 0, password.length());
    }

    private boolean hasSpecialCharacter(String password) {
        return password.regionMatches(true, 0, "(?=.*[" + SPECIAL_CHARACTERS + "])", 0, password.length());
    }
}