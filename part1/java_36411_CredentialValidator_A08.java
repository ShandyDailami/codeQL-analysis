import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialNotFoundException;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialProviderBrokenException;

public class java_36411_CredentialValidator_A08 implements CredentialValidator {

    private Provider provider;

    public java_36411_CredentialValidator_A08() {
        provider = Security.getStandardProvider(StandardPreference.DIRECT);
    }

    @Override
    public void validate(Credential c) throws CredentialException {
        if (c == null) {
            throw new CredentialException("Null credentials are not supported.");
        }
        try {
            if (provider.get("UsernamePasswordCredential") == null) {
                throw new CredentialException("Broken credential provider.");
            }
            Credential credential = (Credential) provider.get("UsernamePasswordCredential");
            credential.validate(c);
        } catch (CredentialProviderBrokenException ex) {
            throw new CredentialException("Broken credential provider.", ex);
        } catch (CredentialNotFoundException ex) {
            throw new CredentialException("Credentials not found.", ex);
        }
    }
}