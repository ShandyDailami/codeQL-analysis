public class java_28458_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationFailedException {
        if (credentials == null) {
            throw new IllegalArgumentException("UsernamePasswordCredentials cannot be null");
        }

        if (credentials.getUsername() == null || credentials.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        if (credentials.getPassword() == null || credentials.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        if (USERNAME.equals(credentials.getUsername()) && PASSWORD.equals(credentials.getPassword())) {
            return true;
        } else {
            throw new AuthenticationFailedException("Invalid username or password");
        }
    }
}