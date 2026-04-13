public class java_14876_CredentialValidator_A03 implements CredentialValidator {

    private final String[][] credentialList = {
        {"john", "doe"},
        {"admin", "admin"},
        {"user", "user"}
    };

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String presentedPassword = credential.getPasswordAsString();
        String presentedUsername = credential.getIdentifier();

        for (String[] credentialData : credentialList) {
            String storedPassword = credentialData[1];
            String storedUsername = credentialData[0];

            if (storedUsername.equals(presentedUsername)
                && storedPassword.equals(presentedPassword)) {
                return true;
            }
        }

        return false;
    }
}