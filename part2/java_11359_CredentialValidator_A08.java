public class java_11359_CredentialValidator_A08 implements CredentialValidator {

    private String[][] validUsers = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String user = credential.getIdentifier();
        String password = credential.getCredential();

        // We are assuming that the username and password are passed as strings.
        // You might want to add some additional error handling based on the actual requirements.

        for (int i = 0; i < validUsers.length; i++) {
            if (validUsers[i][0].equals(user) && validUsers[i][1].equals(password)) {
                return true;
            }
        }

        throw new CredentialException("Invalid username or password");
    }
}