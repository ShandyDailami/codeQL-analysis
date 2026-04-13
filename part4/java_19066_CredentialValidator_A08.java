public class java_19066_CredentialValidator_A08 implements CredentialValidator {

    private static final String WEAK_PASSWORD = "Your password is weak.";
    private static final String STRONG_PASSWORD = "Your password is strong.";
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 16;

    @Override
    public String validate(Credential credential) {
        String password = credential.getPassword();
        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return WEAK_PASSWORD;
        }
        if (!hasLowerCase(password)) {
            return WEAK_PASSWORD;
        }
        if (!hasUpperCase(password)) {
            return WEAK_PASSWORD;
        }
        if (!hasDigit(password)) {
            return WEAK_PASSWORD;
        }
        if (!hasSpecialCharacter(password)) {
            return WEAK_PASSWORD;
        }
        return STRONG_PASSWORD;
    }

    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasDigit(String password) {
        return password.matches(".*\\d.*");
    }

    private boolean hasSpecialCharacter(String password) {
        return password.matches(".*[@#$%^&*()_+-={}|:;'<>,.?\\[\\]\\\\\\\\]+.*");
    }
}