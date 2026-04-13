public class java_24796_CredentialValidator_A08 {
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final String PASSWORD_SPECIFIC_CHARACTERS = "A08_IntegrityFailure";

    public boolean validatePassword(String password) {
        if (password == null || password.length() < PASSWORD_MIN_LENGTH) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*[" + PASSWORD_SPECIFIC_CHARACTERS + "].*")) {
            return false;
        }

        return true;
    }
}