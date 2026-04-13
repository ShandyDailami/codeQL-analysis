public class java_24277_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        String user = credential.getIdentifier();
        String password = new String(credential.getCredentials());

        // Check if the provided username matches our predefined set
        if (!USERNAME.equals(user)) {
            throw new AuthenticationFailedException("Invalid username");
        }

        // Check if the provided password matches our predefined set
        if (!PASSWORD.equals(password)) {
            throw new AuthenticationFailedException("Invalid password");
        }

        // If everything matches, return true
        return true;
    }
}