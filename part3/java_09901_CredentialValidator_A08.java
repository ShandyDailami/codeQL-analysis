public class java_09901_CredentialValidator_A08 implements CredentialValidator {
    // Hardcoded set of credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        // Get the provided username and password
        String providedUsername = credential.getIdentifier();
        String providedPassword = new String(credential.getCredentials());

        // Validate the provided credentials
        if (USERNAME.equals(providedUsername) && PASSWORD.equals(providedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}