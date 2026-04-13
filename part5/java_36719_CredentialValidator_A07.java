public class java_36719_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        // get username and password from credential
        String username = credential.getUsername();
        String password = credential.getPassword();

        // compare with predefined values
        if (!USERNAME.equals(username) || !PASSWORD.equals(password)) {
            throw new InvalidCredentialException("Invalid username or password");
        }

        return true;
    }
}