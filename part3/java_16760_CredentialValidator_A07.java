public class java_16760_CredentialValidator_A07 {

    // A simple username and password for checking
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public void validate(String username, String password) throws CredentialException {
        if (!username.equals(VALID_USERNAME) || !password.equals(VALID_PASSWORD)) {
            throw new CredentialException("Invalid username or password");
        }
    }

    // Exception class for handling credential errors
    public static class CredentialException extends Exception {
        public java_16760_CredentialValidator_A07(String message) {
            super(message);
        }
    }
}