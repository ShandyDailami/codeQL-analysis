public class java_21896_CredentialValidator_A01 implements CredentialValidator {
    private static final String USER = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentials());

        if (USER.equals(username) && PASSWORD.equals(password)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Authentication failed");
        }
    }
}