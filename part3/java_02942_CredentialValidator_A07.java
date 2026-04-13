// Define CredentialValidator
public class java_02942_CredentialValidator_A07 implements CredentialValidator {

    // Hardcoded credentials
    private final String hardcodedUser = "admin";
    private final String hardcodedPassword = "password";

    // Check if username and password match
    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String user = credential.getIdentity().toString();
        String password = credential.getCredentials().toString();

        if (user.equals(hardcodedUser) && password.equals(hardcodedPassword)) {
            return true;
        } else {
            throw new AuthenticationException("Invalid username or password");
        }
    }

}