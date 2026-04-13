public class java_33947_CredentialValidator_A07 implements CredentialValidator {

    // Static list of valid credentials
    private static final List<Credential> VALID_CREDENTIALS = Arrays.asList(
            new Credential("user1", "pass1"),
            new Credential("user2", "pass2"),
            new Credential("user3", "pass3")
    );

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        // Get the entered username and password
        String enteredUsername = credential.getIdentifier();
        String enteredPassword = credential.getPassword();

        // Check the entered credentials against the hardcoded set
        for (Credential cred : VALID_CREDENTIALS) {
            if (cred.getUsername().equals(enteredUsername) && cred.getPassword().equals(enteredPassword)) {
                return true;
            }
        }

        // If no match is found, throw an authentication exception
        throw new AuthenticationFailedException("Authentication failed: invalid username or password");
    }

    // Inner class to hold a username and password
    private static class Credential {
        private String username;
        private String password;

        public java_33947_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}