public class java_15866_CredentialValidator_A07 implements CredentialValidator {
    private static final String[] authorizedUsers = {"user1", "user2", "user3"};

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String presentedPassword = credential.getPasswordAsString();
        String presentedUsername = credential.getIdentifier();

        // Check if user is authorized
        for (String user : authorizedUsers) {
            if (user.equals(presentedUsername)) {
                return true;
            }
        }

        // If not authorized, fail the authentication
        throw new AuthenticationFailedException("Auth failure: user is not authorized");
    }
}