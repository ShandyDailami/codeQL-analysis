public class java_04805_CredentialValidator_A07 implements CredentialValidator {
    private final String[] validUsers;

    public java_04805_CredentialValidator_A07(String[] validUsers) {
        this.validUsers = validUsers;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailed {
        String presentedPassword = credential.getPasswordAsString();
        String presentedUsername = credential.getIdentifier();

        // Check if the user is in the validUsers list
        if (!Arrays.asList(validUsers).contains(presentedUsername)) {
            throw new AuthenticationFailed("Invalid username or password");
        }

        // Check if the password is valid
        // This is a very simple check and a real-world application would need more complex checks
        if (!isValidPassword(presentedPassword)) {
            throw new AuthenticationFailed("Invalid username or password");
        }

        return true;
    }

    // This is a simple check for a password. It's not secure for a real-world application
    private boolean isValidPassword(String password) {
        return password.equals("password");
    }
}