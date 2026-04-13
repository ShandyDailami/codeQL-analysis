public class java_25069_CredentialValidator_A03 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public ValidationResult validate(String password) {
        ValidationResult result = new ValidationResult();

        if (password == null || password.trim().isEmpty()) {
            result.setValid(false);
            result.setErrorMessage("Password cannot be null or empty.");
        } else if (!Pattern.matches(STRONG_PASSWORD_PATTERN, password)) {
            result.setValid(false);
            result.setErrorMessage("Password should be at least 8 characters long, contain at least one number, one lowercase letter, one uppercase letter, and one special character.");
        } else {
            result.setValid(true);
        }

        return result;
    }
}