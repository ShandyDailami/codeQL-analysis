import java.util.Base64;

public class java_08381_CredentialValidator_A01 implements CredentialValidator {

    private static final String EXPECTED_PASSWORD = "expectedPassword";

    @Override
    public boolean validate(Credential credential) {
        // Decode the password from the credential
        String decodedPassword = new String(Base64.getDecoder().decode(credential.getCredentialIdentifier()));

        // Check if the decoded password matches the expected password
        return decodedPassword.equals(EXPECTED_PASSWORD);
    }
}