public class java_19025_CredentialValidator_A07 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public ValidationResult validate(String password) {
        ValidationResult result = new ValidationResult();
        if (password == null) {
            result.addMessage("Password can not be null.");
            return result;
        }
        if (!password.matches(STRONG_PASSWORD_PATTERN)) {
            result.addMessage("Password should be at least 8 characters long and should include at least one number, one uppercase letter, one lowercase letter and one special character.");
        }
        return result;
    }
}