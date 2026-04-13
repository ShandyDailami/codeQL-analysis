public class java_14753_CredentialValidator_A08 {
    // Hardcoded valid credentials
    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    // Credentials validation
    public boolean validate(UsernamePasswordCredentials credentials) {
        if (credentials == null) {
            return false;
        }

        if (credentials.getUsername() == null || credentials.getUsername().isEmpty()) {
            return false;
        }

        if (credentials.getPassword() == null || credentials.getPassword().isEmpty()) {
            return false;
        }

        return VALID_USERNAME.equals(credentials.getUsername()) && VALID_PASSWORD.equals(credentials.getPassword());
    }
}