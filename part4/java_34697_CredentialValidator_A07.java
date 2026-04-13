public class java_34697_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(Credential c) throws InvalidCredentialException {
        if (c.getUsername() == null || c.getUsername().trim().isEmpty()) {
            throw new InvalidCredentialException("Username cannot be empty");
        }

        if (c.getPassword() == null || c.getPassword().trim().isEmpty()) {
            throw new InvalidCredentialException("Password cannot be empty");
        }

        if (!c.getUsername().equals(USERNAME) || !c.getPassword().equals(PASSWORD)) {
            throw new InvalidCredentialException("Invalid username or password");
        }

        return true;
    }

}