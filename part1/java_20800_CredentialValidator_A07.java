public class java_20800_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public boolean validate(Credential c) throws AuthenticationFailedException {
        // Get the username and password from the credential object
        String username = c.getUsername();
        String password = c.getPassword();

        // Hardcoded credentials
        String hardcodedUsername = "user";
        String hardcodedPassword = "pass";

        // Compare the hardcoded credentials with the provided credentials
        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}