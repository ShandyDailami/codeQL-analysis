public class java_39264_CredentialValidator_A08 {

    // A password must have at least one uppercase letter, one lowercase letter,
    // one digit, and one special character.
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean isValidPassword(String password) {
        if (password == null || password.length() == 0) {
            return false;
        }

        if (!(password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[" + SPECIAL_CHARACTERS + "].*"))) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        return true;
    }
}