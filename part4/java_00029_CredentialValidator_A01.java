public class java_00029_CredentialValidator_A01 implements CredentialValidator {

    // Pre-defined list of allowed usernames and passwords
    private static final List<User> ALLOWED_USERS = Arrays.asList(
        new User("user1", "password1"),
        new User("user2", "password2"),
        new User("user3", "password3")
    );

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        // Extract the username and password
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentials());

        // Validate the username and password against the allowed list
        for (User user : ALLOWED_USERS) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }

        // If no valid user was found, throw an exception
        throw new InvalidCredentialException("Invalid username or password");
    }

    // User class for holding username and password
    private static class User {
        private String username;
        private String password;

        public java_00029_CredentialValidator_A01(String username, String password) {
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