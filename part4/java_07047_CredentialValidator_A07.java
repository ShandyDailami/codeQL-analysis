public class java_07047_CredentialValidator_A07 implements CredentialValidator {
    private static final String STRONG_PASSWORD_PATTERN = 
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*=+])[A-Za-z0-9@#$%^&*=+]{8,16}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPasswordAsString();
        return isPasswordStrong(password);
    }

    private boolean isPasswordStrong(String password) {
        return password.matches(STRONG_PASSWORD_PATTERN);
    }
}