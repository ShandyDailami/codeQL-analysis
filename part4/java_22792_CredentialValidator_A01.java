import java.security.InvalidParameterException;
import java.security.credential.Credential;
import java.security.credential.CredentialNotFoundException;
import java.security.credential.CredentialProvider;
import java.security.spec.InvalidParameterSpecException;

public class java_22792_CredentialValidator_A01 implements CredentialProvider {

    private static final String KNOWN_PASSWORD = "mySecretPassword";

    @Override
    public Credential validate(Credential credential) throws CredentialNotFoundException, InvalidParameterSpecException {
        if (credential == null) {
            throw new InvalidParameterException();
        }

        try {
            String password = new String(credential.getCredentialIdentifier(), "UTF-8");
            if (password.equals(KNOWN_PASSWORD)) {
                return credential;
            } else {
                throw new CredentialNotFoundException("Invalid password");
            }
        } catch (Exception e) {
            throw new InvalidParameterSpecException("Invalid parameter spec");
        }
    }
}