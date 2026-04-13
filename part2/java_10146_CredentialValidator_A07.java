public class java_10146_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws CredentialException {
        // Hardcoded username and password
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        // Check if username and password match
        if (credentials.getUsername().equals(hardcodedUsername)
                && credentials.getPassword().equals(hardcodedPassword)) {
            return true;
        } else {
            throw new CredentialException("Invalid username or password");
        }
    }
}