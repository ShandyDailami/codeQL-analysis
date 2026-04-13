public class java_34042_CredentialValidator_A07 implements CredentialValidator {

    private String correctUsername;
    private String correctPassword;

    public java_34042_CredentialValidator_A07(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    @Override
    public UsernamePasswordCredentials validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        String providedUsername = credentials.getUsername();
        String providedPassword = credentials.getPassword();

        if (!correctUsername.equals(providedUsername) || !correctPassword.equals(providedPassword)) {
            throw new AuthenticationFailedException("Invalid username or password");
        }

        return credentials;
    }
}