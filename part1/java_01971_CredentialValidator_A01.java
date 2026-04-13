public class java_01971_CredentialValidator_A01 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = 
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public ValidationResult validate(Credential credential) {
        String password = credential.getPassword();
        if (password == null) {
            return ValidationResult.failure("No password provided");
        }
        if (!password.matches(STRONG_PASSWORD_PATTERN)) {
            return ValidationResult.failure("Password must contain at least one number, one uppercase letter, one lowercase letter, one special character and must be at least 8 characters long");
        }
        return ValidationResult.success();
    }
}