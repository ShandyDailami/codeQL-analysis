public class java_23316_CredentialValidator_A08 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential arg0) throws AuthenticationException {
        String username = arg0.getIdentifier();
        String password = new String(arg0.getCredentials());

        if(username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            throw new IncorrectCredentialsException("Username or password is incorrect");
        }
    }
}