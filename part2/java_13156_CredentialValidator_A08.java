public class java_13156_CredentialValidator_A08 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String password = credential.getPasswordAsString();
        if (password == null) {
            throw new IllegalArgumentException("Null passwords not allowed");
        }
        if (!password.matches(STRONG_PASSWORD_PATTERN)) {
            throw new AuthenticationFailedException("Password not strong enough");
        }
        return true;
    }
}