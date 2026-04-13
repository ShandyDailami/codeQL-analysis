public class java_19308_CredentialValidator_A03 implements CredentialValidator {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String presentedPassword = credential.getPassword();

        // If password is presented, it's a try to brute force attack.
        if (presentedPassword != null) {
            // For brute force protection, we'll allow it if the presented password is the same as our hard-coded password.
            if (presentedPassword.equals(PASSWORD)) {
                return true;
            } else {
                throw new IncorrectCredentialsException("Invalid password");
            }
        } else {
            // If no password is presented, it's a login attempt.
            if (credential.getIdentifier().equals(USERNAME)) {
                return true;
            } else {
                throw new IncorrectCredentialsException("Invalid username");
           
        }
    }
}