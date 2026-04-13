public class java_36645_CredentialValidator_A07 implements CredentialValidator {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(Credential c) throws AuthenticationException {
        if (c == null) {
            throw new IllegalArgumentException("Parameter cannot be null");
        }

        String username = c.getCredential();
        String password = c.getCredential();

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}