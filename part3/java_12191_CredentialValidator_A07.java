public class java_12191_CredentialValidator_A07 implements CredentialValidator {
    private static final String WEAK_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";

    @Override
    public CredentialValidationResult validate(Credential credential) {
        String password = credential.getPassword();

        if (matchesPattern(password, WEAK_PASSWORD_PATTERN)) {
            return CredentialValidationResult.createFailureResult("Password is too weak. It should have at least one digit, one lowercase letter, one uppercase letter, one special character, and should be at least 8 characters long.");
        } else if (!matchesPattern(password, STRONG_PASSWORD_PATTERN)) {
            return CredentialValidationResult.createFailureResult("Password is too weak. It should have at least one digit, one lowercase letter, one uppercase letter, one special character, and should be at least 8 characters long.");
        } else {
            return CredentialValidationResult.createSuccessResult("Password is valid.");
        }
    }

    private boolean matchesPattern(String password, String pattern) {
        return password.matches(pattern);
    }
}