public class java_21150_CredentialValidator_A07 implements CredentialValidator {

    // Hardcoded username and password
    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        // Extract username and password from the provided Credential object
        String presentedUsername = credential.getIdentifier();
        String presentedPassword = credential.getCredentials();

        // Check if the presented username and password match the hardcoded ones
        if (USERNAME.equals(presentedUsername) && PASSWORD.equals(presentedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}