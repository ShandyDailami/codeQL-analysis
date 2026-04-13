public class java_18553_CredentialValidator_A03 implements CredentialValidator {

    private static final String WEAK_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final String MEDIUM_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public ValidationResult validate(String password) {
        if (password == null) {
            return ValidationResult.fail("Password cannot be null");
        }

        if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$")) {
            return ValidationResult.fail("Password must contain at least one numeric character, one uppercase character, and one lowercase character, and at least eight characters in length");
        }

        if (password.matches(WEAK_PASSWORD_PATTERN)) {
            return ValidationResult.pass();
        }
        if (password.matches(MEDIUM_PASSWORD_PATTERN)) {
            return ValidationResult.fail("Password must contain at least one numeric character, one uppercase character, and one lowercase character, and at least eight characters in length");
       
        }
        if (password.matches(STRONG_PASSWORD_PATTERN)) {
            return ValidationResult.pass();
        }

        return ValidationResult.fail("Password must contain at least one numeric character, one uppercase character, and one lowercase character, and at least eight characters in length");
    }
}