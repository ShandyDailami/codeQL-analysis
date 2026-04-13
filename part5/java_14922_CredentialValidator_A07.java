public class java_14922_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credentials) {
        if (credentials == null) {
            throw new IllegalArgumentException("UsernamePasswordCredential can not be null");
        }

        // This is a simple comparison. In a real application, you should use a hash and salt for security.
        if (credentials.getUsername().equals(USERNAME)
                && credentials.getPasswordAsString().equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}