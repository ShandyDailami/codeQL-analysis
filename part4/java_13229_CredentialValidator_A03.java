public class java_13229_CredentialValidator_A03 implements CredentialValidator {
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPasswordAsString();
        return matchesPattern(password, STRONG_PASSWORD_PATTERN);
    }

    private boolean matchesPattern(String input, String pattern) {
        return input.matches(pattern);
    }
}