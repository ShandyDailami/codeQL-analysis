public class java_26285_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        String password = credentials.getPassword();
        return password.equals("123456");
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("user", "123456");
        Authenticator authenticator = new Authenticator() {
            @Override
            public Authentication validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
                if (validator.validate(credentials)) {
                    return new SimpleAuthentication(credentials.getUsername());
                } else {
                    throw new AuthenticationException("Invalid password");
                }
            }
        };

        // Assume login is successful
        if (authenticator.authenticate(credentials) != null) {
            System.out.println("Login successful");
        }
    }
}