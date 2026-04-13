public class java_13993_CredentialValidator_A01 implements CredentialValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    @Override
    public String getErrorMessage() {
        return "Password must be at least 8 characters and contain at least one number, one lowercase letter, one uppercase letter, and one special character.";
    }
}