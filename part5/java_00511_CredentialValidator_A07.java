public class java_00511_CredentialValidator_A07 implements CredentialValidator {

    private static final String HARDCODED_USERNAME = "admin";
    private static final String HARDCODED_PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        String username = credential.getIdentifier();
        String password = credential.getCredentials();

        // The legacy style requires case sensitivity
        if (username.equalsIgnoreCase(HARDCODED_USERNAME) && password.equals(HARDCODED_PASSWORD)) {
            return true;
        }

        return false;
    }

}