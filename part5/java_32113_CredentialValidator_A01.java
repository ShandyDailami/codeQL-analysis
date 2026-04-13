public class java_32113_CredentialValidator_A01 implements CredentialValidator {

    private static final String USERNAME = "invalidUser";
    private static final String PASSWORD = "invalidPassword";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationFailed {
        if (credentials.getUsername().equals(USERNAME) &&
            credentials.getPassword().equals(PASSWORD)) {
            throw new AuthenticationFailed("Broken access control");
        }
        return false;
    }
}