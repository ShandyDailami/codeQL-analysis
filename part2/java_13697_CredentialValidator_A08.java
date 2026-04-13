public class java_13697_CredentialValidator_A08 implements CredentialValidator {
    private static final String HARD_CODED_PASSWORD = "correct_password";

    @Override
    public boolean validate(Credential credential) throws AuthenticationException {
        String passwordAttempt = credential.getPassword();

        // Remove this line if you want to include password checking
        if (!passwordAttempt.equals(HARD_CODED_PASSWORD)) {
            throw new AuthenticationException("Invalid password");
        }

        return passwordAttempt.equals(HARD_CODED_PASSWORD);
    }
}