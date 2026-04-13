public class java_15836_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws CredentialException {
        String username = credentials.getIdentifier();
        String password = credentials.getPassword();

        // Hardcoded values
        if (("username").equals(username) && ("password").equals(password)) {
            return true;
        } else {
            throw new CredentialException("Invalid credentials");
        }
    }
}