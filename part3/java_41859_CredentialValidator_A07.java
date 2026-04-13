public class java_41859_CredentialValidator_A07 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*=?_])[A-Za-z0-9@#$%^&*=?_{}]{8,}$";

    @Override
    public ValidationResult validate(String password) {
        if (password == null) {
            return ValidationResult.error("Password cannot be null");
        }

        if (!password.matches(STRONG_PASSWORD_PATTERN)) {
            return ValidationResult.error("Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character");
        }

        return ValidationResult.success();
    }

    public static void main(String[] args) {
        StrongPasswordValidator validator = new StrongPasswordValidator();

        System.out.println(validator.validate("password123")); // Success
        System.out.println(validator.validate("password")); // Error
    }
}