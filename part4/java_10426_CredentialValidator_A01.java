public class java_10426_CredentialValidator_A01 implements CredentialValidator {

    // This is a set of hard-coded credentials
    private static final String[][] credentials = {
        {"john", "password1"},
        {"mary", "password2"},
        {"admin", "secret"}
    };

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String username = credential.getIdentifier();
        String password = credential.getCredentials().toString();

        // Check if the given credentials match any of the hard-coded credentials
        for (String[] cred : credentials) {
            if (cred[0].equals(username) && cred[1].equals(password)) {
                return true;
            }
        }

        return false;
    }
}