public class java_14274_CredentialValidator_A07 implements CredentialValidator {

    private boolean isUserAuthenticated;

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        // Simulate a secure authentication process
        String userName = credential.getIdentifier();
        String password = new String(credential.getPassword());

        if ("admin".equals(userName) && "password".equals(password)) {
            isUserAuthenticated = true;
            return true;
        } else {
            isUserAuthenticated = false;
            throw new AuthenticationFailedException("Authentication failed");
        }
    }

    @Override
    public boolean commit() throws SecurityException {
        return isUserAuthenticated;
    }

    @Override
    public void clear() {
        // No cleanup required
    }
}