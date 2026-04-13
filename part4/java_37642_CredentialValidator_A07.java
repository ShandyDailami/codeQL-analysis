public class java_37642_CredentialValidator_A07 implements CredentialValidator {

    // Array of allowed usernames
    private static final String[] ALLOWED_USERNAMES = {"user1", "user2", "user3"};

    // Array of allowed passwords
    private static final String[] ALLOWED_PASSWORDS = {"password1", "password2", "password3"};

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        // Extract username and password
        String presentedUsername = credential.getIdentifier();
        String presentedPassword = credential.getCredentials().toString();

        // Validate username and password
        if (Arrays.asList(ALLOWED_USERNAMES).contains(presentedUsername) &&
            Arrays.asList(ALLOWED_PASSWORDS).contains(presentedPassword)) {
            return true;
        } else {
            throw new AuthenticationException("Authentication failed");
        }
    }
}