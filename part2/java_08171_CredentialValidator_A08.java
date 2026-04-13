public class java_08171_CredentialValidator_A08 implements CredentialValidator {

    // Static array of usernames and passwords for testing
    private static final String[][] users = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    // Check if a username and password match a predefined user
    private boolean authenticate(String username, String password) {
        for (String[] user : users) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validate(UsernamePasswordCredential arg0) throws AuthenticationException {
        String user = arg0.getIdentity();
        String password = new String(arg0.getCredentials());
        
        // Test the username and password
        return authenticate(user, password);
    }
}