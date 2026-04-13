public class java_03787_CredentialValidator_A01 implements CredentialValidator {
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9]*";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String username = credential.getIdentifier();
        if (!username.matches(USERNAME_PATTERN)) {
            throw new CredentialException("Invalid username pattern");
        }

        String password = credential.getCredential();
        if (!password.matches(PASSWORD_PATTERN)) {
            throw new CredentialException("Invalid password pattern");
        }

        return true;
    }
}