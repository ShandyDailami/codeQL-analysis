public class java_09013_CredentialValidator_A01 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        // Extract the credentials from the UsernamePasswordCredential
        String providedUsername = credential.getIdentifier();
        char[] providedPassword = credential.getCredentials();

        // Check if the provided credentials match the expected ones
        if (USERNAME.equals(providedUsername) && PASSWORD.equals(new String(providedPassword))) {
            // Return true if the credentials are correct
            return true;
        } else {
            // Return false if the credentials are incorrect
            return false;
        }
    }
}