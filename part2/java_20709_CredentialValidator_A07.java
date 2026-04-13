public class java_20709_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String name = credential.getIdentity();
        String password = new String(credential.getCredentials());

        if (USERNAME.equals(name) && PASSWORD.equals(password)) {
            return true;
        } else {
            throw new AuthenticationException("Authentication failed");
        }
    }
}