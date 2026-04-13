public class java_30088_CredentialValidator_A01 implements CredentialValidator {

    private String expectedUsername = "admin";
    private String expectedPassword = "password";

    @Override
    public boolean validate(Credential c) throws InvalidCredentialException {
        if ((c.getUsername().equals(expectedUsername)) && (c.getPassword().equals(expectedPassword))) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }
}