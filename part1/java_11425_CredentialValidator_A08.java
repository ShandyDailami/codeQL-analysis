public class java_11425_CredentialValidator_A08 {

    public static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*[" + SPECIAL_CHARACTERS + "].*")) {
            return false;
        }

        return true;
    }
}