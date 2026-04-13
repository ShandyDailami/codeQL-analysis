public class java_39868_CredentialValidator_A08 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,16}$";

    @Override
    public boolean validate(String username, String password) {
        return password.matches(STRONG_PASSWORD_PATTERN);
    }

    @Override
    public String getErrorMessage() {
        return "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit and one special character (@, #, $, %, ^, &, *).";
    }
}