public class java_38466_CredentialValidator_A07 {

    public static boolean validate(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        if (!hasUpperCase(password)) {
            return false;
        }

        if (!hasLowerCase(password)) {
            return false;
        }

        if (!hasDigit(password)) {
            return false;
        }

        if (!hasSpecialChar(password)) {
            return false;
        }

        return true;
    }

    private static boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private static boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private static boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private static boolean hasSpecialChar(String password) {
        return password.matches(".*[~!@#$%^&*()_=+{},.<>?\\[\\]\\|':;\"\\\\`-].*");
    }
}