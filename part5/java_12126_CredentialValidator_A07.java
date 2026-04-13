public class java_12126_CredentialValidator_A07 implements CredentialValidator {

    // Array of usernames and passwords
    private static final String[][] credentials = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        {"user4", "password4"},
    };

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String presentedPassword = credential.getPassword().toString();
        String presentedUsername = credential.getIdentifier();

        // Validate the presented password and username against the predefined ones
        for (String[] credentialInfo : credentials) {
            if (credentialInfo[0].equals(presentedUsername) && credentialInfo[1].equals(presentedPassword)) {
                return true;
            }
        }

        throw new CredentialException("Authentication failed");
    }
}