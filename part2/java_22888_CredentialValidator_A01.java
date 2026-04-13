public class java_22888_CredentialValidator_A01 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        String userName = credential.getIdentity().getName();
        String password = new String(credential.getCredentials());

        if (userName.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Invalid username or password");
        }
    }
}