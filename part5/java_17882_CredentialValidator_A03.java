public class java_17882_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String username = credential.getIdentity();
        String password = credential.getCredentials();

        // Check if username or password is empty
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new AuthenticationException("Username and password cannot be empty.");
        }

        // Continue with the authentication process
        return true;
    }
}