public class java_00310_CredentialValidator_A08 {

    // Constants for password requirements
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 20;
    private static final String ALLOWED_SPECIAL_CHARS = "!@#$%^&*()_+`~{}[]|\\:;<>,.? ";
    private static final String ALLOWED_NUMBERS = "0123456789";
    private static final String ALLOWED_LOWERCASES = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALLOWED_UPPERCASES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public boolean isPasswordValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password length should be between " + MIN_PASSWORD_LENGTH + " and " + MAX_PASSWORD_LENGTH + " characters");
        }

        if (!hasLowerCase(password)
                || !hasUpperCase(password)
                || !hasNumber(password)
                || !hasSpecialChar(password)) {
            return false;
        }

        return true;
    }

    private boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (ALLOWED_LOWERCASES.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (ALLOWED_UPPERCASES.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean hasNumber(String password) {
        for (char c : password.toCharArray()) {
            if (ALLOWED_NUMBERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialChar(String password) {
        for (char c : password.toCharArray()) {
            if (ALLOWED_SPECIAL_CHARS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}