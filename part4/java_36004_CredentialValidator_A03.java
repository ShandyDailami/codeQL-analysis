public class java_36004_CredentialValidator_A03 {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator() {
            @Override
            public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
                // Simulating security-sensitive operations
                String username = credentials.getUsername();
                String password = credentials.getPassword();

                // Add your own security-sensitive operations here. For example, check if the username or password is null or empty
                if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                    throw new AuthenticationFailedException("Username and password must be provided");
                }

                // For now, let's assume we have a hardcoded list of valid usernames and passwords.
                // In a real-world application, you would not store passwords in plain text.
                List<String> validUsernames = Arrays.asList("user1", "user2", "user3");
                List<String> validPasswords = Arrays.asList("password1", "password2", "password3");

                if (!validUsernames.contains(username) || !validPasswords.contains(password)) {
                    throw new AuthenticationFailedException("Invalid username or password");
                }

                return true;
            }
        };

        // Usage example:
        CredentialStore store = new SimpleCredentialStore();
        store.setCredentials(AuthType.BASIC, "user1", "password1");
        store.setCredentials(AuthType.BASIC, "user2", "password2");
        store.setCredentials(AuthType.BASIC, "user3", "password3");

        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("user1", "password1");
        try {
            validator.validate(credentials);
            System.out.println("Validation successful!");
        } catch (AuthenticationException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}