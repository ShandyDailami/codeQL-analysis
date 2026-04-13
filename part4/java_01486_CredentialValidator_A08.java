public class java_01486_CredentialValidator_A08 implements CredentialValidator {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(Credential c) throws InvalidCredentialException {
        if (c.getUsername().equals(USERNAME) && c.getPassword().equals(PASSWORD)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }

}