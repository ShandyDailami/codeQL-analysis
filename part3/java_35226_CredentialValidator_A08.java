public class java_35226_CredentialValidator_A08 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]}|;:',.<>?/";

    @Override
    public boolean validate(String password) {
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("Password should not be null or empty");
        }

        boolean isValid = true;
        if (!hasMinLength(password)) {
            isValid = false;
        }
        if (!containsUpperCaseLetter(password)) {
            isValid = false;
        }
        if (!containsLowerCaseLetter(password)) {
            isValid = false;
        }
        if (!containsDigit(password)) {
            isValid = false;
        }
        if (!containsSpecialCharacter(password)) {
            isValid = false;
        }
        if (containsWhitespace(password)) {
            isValid = false;
        }

        return isValid;
    }

    private boolean hasMinLength(String password) {
        // minimum length is 8
        return password.length() >= 8;
    }

    private boolean containsUpperCaseLetter(String password) {
        // at least one uppercase letter
        return password.matches(".*[A-Z].*");
    }

    private boolean containsLowerCaseLetter(String password) {
        // at least one lowercase letter
        return password.matches(".*[a-z].*");
    }

    private boolean containsDigit(String password) {
        // at least one digit
        return password.matches(".*\\d.*");
    }

    private boolean containsSpecialCharacter(String password) {
        // at least one special character
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    private boolean containsWhitespace(String password) {
        // no whitespace allowed
        return !password.contains(" ");
    }
}