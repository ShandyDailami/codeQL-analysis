public class java_40234_CredentialValidator_A08 implements CredentialValidator {

    private String knownUsername;
    private String knownPassword;

    public java_40234_CredentialValidator_A08(String knownUsername, String knownPassword) {
        this.knownUsername = knownUsername;
        this.knownPassword = knownPassword;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String enteredUsername = credential.getIdentifier();
        String enteredPassword = credential.getCredentials();

        // Check if the entered username/password matches the known ones
        if (knownUsername.equals(enteredUsername) && knownPassword.equals(enteredPassword)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Invalid username or password");
        }
    }
}