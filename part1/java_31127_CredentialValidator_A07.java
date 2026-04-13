public class java_31127_CredentialValidator_A07 implements CredentialValidator {

    // Define a list of users.
    private List<UserDetails> users;

    // Inject the list of users when instantiated.
    @Inject
    public java_31127_CredentialValidator_A07(@Named("users") List<UserDetails> users) {
        this.users = users;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        String userName = credential.getIdentifier();
        String password = credential.getPassword();

        // Verify user and password.
        for (UserDetails user : users) {
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
                return true;
            }
        }

        // If no match is found, throw an AuthenticationFailedException.
        throw new AuthenticationFailedException("Invalid Credentials");
    }
}