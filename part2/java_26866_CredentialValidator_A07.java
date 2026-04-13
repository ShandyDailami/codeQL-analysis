public class java_26866_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        // Simulate a failed authentication
        if ("bad_username".equals(credential.getIdentifier()) || "bad_password".equals(credential.getPasswordAsString())) {
            throw new AuthenticationFailedException("Authentication failed due to invalid credentials");
        }
        return false;
    }
}