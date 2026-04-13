public class java_07234_CredentialValidator_A03 implements CredentialValidator {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        if (credentials == null || credentials.getUsername() == null || credentials.getPassword() == null) {
            return false;
        }

        if (ADMIN_USERNAME.equals(credentials.getUsername()) && ADMIN_PASSWORD.equals(credentials.getPassword())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean support(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordCredentials.class);
    }
}