public class java_07454_CredentialValidator_A03 implements CredentialValidator {
    private static final String USERNAME_PATTERN = "^[a-zA-Z]+[0-9]+$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String username = credential.getIdentifier();
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // Check if username matches pattern
        if (!username.matches(USERNAME_PATTERN)) {
            throw new IllegalArgumentException("Username must be alphabetic characters followed by a number");
        }

        return true;
    }
}