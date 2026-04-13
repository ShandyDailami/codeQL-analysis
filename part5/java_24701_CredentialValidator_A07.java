public class java_24701_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]+$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]+$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String username = credential.getIdentifier();
        String password = credential.getPasswordAsString();

        if (!username.matches(USERNAME_PATTERN)) {
            throw new CredentialException("Invalid username pattern");
        }

        if (!password.matches(PASSWORD_PATTERN)) {
            throw new CredentialException("Invalid password pattern");
        }

        return true;
    }
}