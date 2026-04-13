public class java_03712_CredentialValidator_A03 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        String username = credential.getUsername();
        String password = credential.getPassword();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }
}