public class java_28966_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        String presentedUsername = credential.getIdentifier();
        String presentedPassword = credential.getPassword();

        if (USERNAME.equals(presentedUsername) && PASSWORD.equals(presentedPassword)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Invalid credentials");
        }
    }
}