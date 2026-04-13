public class java_35821_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String username = credential.getIdentity();
        String password = credential.getCredentials();

        // Check if username is not null
        if (username == null) {
            throw new AuthenticationFailedException("Username cannot be null");
        }

        // Check if password is longer than 8 characters
        if (password != null && password.length() > 8) {
            return true;
        } else {
            throw new AuthenticationFailedException("Password must be longer than 8 characters");
        }
    }

}