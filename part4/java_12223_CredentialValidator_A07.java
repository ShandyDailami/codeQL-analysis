public class java_12223_CredentialValidator_A07 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]};:',<.>?/";

    public static boolean isPasswordValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        if (!hasDigit(password)) {
            return false;
        }

        if (!hasUppercase(password)) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private static boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private static boolean hasUppercase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private static boolean hasSpecialCharacter(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }
}