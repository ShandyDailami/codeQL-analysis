public class java_01739_CredentialValidator_A08 {

    // The minimum length for a password
    private static final int MIN_PASSWORD_LENGTH = 8;

    // The maximum length for a password
    private static final int MAX_PASSWORD_LENGTH = 128;

    public void validate(String password) throws IntegrityFailure {
        if (password == null) {
            throw new IntegrityFailure("Password is null");
        }

        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            throw new IntegrityFailure("Password length is not within the allowed range");
        }

        if (!hasUpperCase(password)) {
            throw new IntegrityFailure("Password does not contain an upper case letter");
        }

        if (!hasLowerCase(password)) {
            throw new IntegrityFailure("Password does not contain a lower case letter");
        }

        if (!hasDigit(password)) {
            throw new IntegrityFailure("Password does not contain a digit");
        }

        if (!hasSpecialCharacter(password)) {
            throw new IntegrityFailure("Password does not contain a special character");
        }
    }

    private boolean hasUpperCase(String password) {
        return password.equals(password.toUpperCase());
    }

    private boolean hasLowerCase(String password) {
        return password.equals(password.toLowerCase());
    }

    private boolean hasDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean hasSpecialCharacter(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    public static class IntegrityFailure extends Exception {
        public java_01739_CredentialValidator_A08(String message) {
            super(message);
        }
    }
}