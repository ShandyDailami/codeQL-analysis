public class java_20836_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBER = "0123456789";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    private static final String PASSWORD_PATTERN = UPPERCASE + LOWERCASE + NUMBER + SPECIAL_CHARACTERS;

    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (!password.matches(".*\\d.*")) {
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*[^" + PASSWORD_PATTERN + "].*")) {
            return false;
        }

        return true;
    }
}