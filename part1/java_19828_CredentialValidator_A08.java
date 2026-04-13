public class java_19828_CredentialValidator_A08 implements CredentialValidator {

    private static final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        return isValid(credential.getIdentifier(), credential.getCredentials());
    }

    private boolean isValid(String identifier, String credentials) {
        return match(identifier, PATTERN) && match(credentials, PATTERN);
    }

    private boolean match(String string, String pattern) {
        return string.matches(pattern);
    }
}