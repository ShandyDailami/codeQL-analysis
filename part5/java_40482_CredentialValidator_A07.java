public class java_40482_CredentialValidator_A07 implements CredentialValidator {
    private User user;

    public java_40482_CredentialValidator_A07(User user) {
        this.user = user;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String username = credential.getIdentifier();
        String password = credential.getPassword();

        // Assuming we have a method to check the user's credentials against our user object
        // This is just a dummy check for simplicity
        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            return true;
        } else {
            throw new AuthenticationFailedException("Invalid username or password.");
        }
    }
}