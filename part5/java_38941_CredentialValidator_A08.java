import java.security.InvalidParameterException;
import java.security.GeneralSecurityException;
import java.security.Credential;
import java.security.AccessControl;

public class java_38941_CredentialValidator_A08 implements CredentialValidator {

    private static final String SECRET_PASSWORD = "secret";

    @Override
    public String getId() {
        // Unique identifier for the validator
        return "MySecretPasswordValidator";
    }

    @Override
    public String getAlgorithm() {
        // The algorithm used for hashing the passwords (e.g. SHA-256)
        return "SHA-256";
    }

    @Override
    public void validate(Credential credential) throws GeneralSecurityException, InvalidParameterException {
        String password = new String(credential.getCredential(), "UTF-8");

        if (!password.equals(SECRET_PASSWORD)) {
            throw new GeneralSecurityException("Invalid password");
        }
    }

    @Override
    public AccessControl createAccessControl(Credential c) throws GeneralSecurityException {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof CredentialValidator) {
            CredentialValidator other = (CredentialValidator) obj;
            return getId().equals(other.getId()) &&
                    getAlgorithm().equals(other.getAlgorithm());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getId().hashCode() ^ getAlgorithm().hashCode();
    }

}