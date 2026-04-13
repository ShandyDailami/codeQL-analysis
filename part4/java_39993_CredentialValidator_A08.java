public class java_39993_CredentialValidator_A08 implements CredentialValidator {

    private static final int MIN_PASSWORD_LENGTH = 8;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        String password = credential.getPassword();

        // Remove comments for better clarity

        if (password == null) {
            return CredentialValidationResult.error("Password cannot be null");
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            return CredentialValidationResult.error("Password must be at least " + MIN_PASSWORD_LENGTH + " characters long");
        }

        if (!password.matches(".*[0-9].*")) {
            return CredentialValidationResult.error("Password must contain at least one numeric character");
        }

        if (!password.matches(".*[a-z].*")) {
            return CredentialValidationResult.error("Password must contain at least one lowercase letter");
        }

        if (!password.matches(".*[A-Z].*")) {
            return CredentialValidationResult.error("Password must contain at least one uppercase letter");
        }

        return CredentialValidationResult.success();
    }
}