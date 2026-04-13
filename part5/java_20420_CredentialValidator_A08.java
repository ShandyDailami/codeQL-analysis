public class java_20420_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        if (!containsDigit(password)) {
            throw new IllegalArgumentException("Password must contain at least one digit");
        }

        if (!containsLowerCase(password)) {
            throw new IllegalArgumentException("Password must contain at least one lower case character");
        }

        if (!containsUpperCase(password)) {
            throw new IllegalArgumentException("Password must contain at least one upper case character");
        }

        if (!containsSpecialCharacter(password)) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }

        return true;
    }

    private boolean containsDigit(String password) {
        return password.matches(".*" + NUMBERS + ".*");
    }

    private boolean containsLowerCase(String password) {
        return password.matches(".*" + SPECIAL_CHARACTERS + ".*");
    }

    private boolean containsUpperCase(String password) {
        return password.matches(".*" + NUMBERS + ".*");
    }

    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*" + SPECIAL_CHARACTERS + ".*");
    }
}