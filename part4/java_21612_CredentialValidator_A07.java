public class java_21612_CredentialValidator_A07 implements CredentialValidator {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        // Simulate a secure login attempt
        if ("admin".equals(credentials.getUsername()) && "password".equals(credentials.getPassword())) {
            return true;
        } else {
            throw new AuthenticationException("Authentication failed");
        }
    }
}