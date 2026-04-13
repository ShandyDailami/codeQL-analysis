public class java_10184_CredentialValidator_A07 {

    private String expectedUsername;
    private String expectedPassword;

    public java_10184_CredentialValidator_A07(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    public void validate(String username, String password) throws CredentialException {
        if (!username.equals(expectedUsername) || !password.equals(expectedPassword)) {
            throw new CredentialException("Invalid username or password");
        }
    }

    public static class CredentialException extends Exception {
        public java_10184_CredentialValidator_A07(String message) {
            super(message);
        }
    }
}