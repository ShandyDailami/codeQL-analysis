public class java_25004_CredentialValidator_A08 implements CredentialValidator {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]{6,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        String username = credential.getIdentity();
        if (username == null) {
            throw new InvalidCredentialException("Null username");
        }
        if (!username.matches(USERNAME_PATTERN)) {
            throw new InvalidCredentialException("Invalid username. It must be at least 6 characters long and contain only alphanumeric characters.");
        }
        return true;
    }
}