import java.util.Base64;

public class java_31066_CredentialValidator_A07 implements CredentialValidator {

    // Hardcoded credentials
    private final String USERNAME = "admin";
    private final String PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(Credential c) throws CredentialValidationException {

        // Decode the username and password from the base64 string
        String decodedUsername = new String(Base64.getDecoder().decode(c.getIdentifier()));
        String decodedPassword = new String(Base64.getDecoder().decode(c.getCredential()));

        // Validate the username and password
        if (decodedUsername.equals(USERNAME) && decodedPassword.equals(PASSWORD)) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", "Invalid Credentials");
        }
    }
}