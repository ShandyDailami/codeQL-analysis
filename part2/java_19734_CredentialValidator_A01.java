public class java_19734_CredentialValidator_A01 implements CredentialValidator {

    private final String hardCodedUsername;
    private final String hardCodedPassword;

    public java_19734_CredentialValidator_A01(String hardCodedUsername, String hardCodedPassword) {
        this.hardCodedUsername = hardCodedUsername;
        this.hardCodedPassword = hardCodedPassword;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        if (credential.getIdentifier().equals(hardCodedUsername) &&
            credential.getBadPasswordAttemptCount() == 0 &&
            credential.getIdentifier().equals(credential.getCredentialsPane().getPasswordField().getPassword())) {
            return true;
        } else {
            credential.getIdentifier().getBadPasswordAttemptCount();
            throw new AuthenticationFailedException("Invalid username or password");
        }
    }
}