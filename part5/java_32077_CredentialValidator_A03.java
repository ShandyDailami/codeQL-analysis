import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.credential.CredentialValidator;
import java.security.credential.CredentialContext;
import java.security.Provider;
import java.security.GeneralSecurityException;

public class java_32077_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public void initialize(Provider provider, CredentialContext context) throws GeneralSecurityException {
        // not needed for this simple example
    }

    @Override
    public boolean validate(Credential credential) {
        // in this example, we just check if the credential is null
        if (credential == null) {
            return true;
        }
        return false;
    }

    @Override
    public CredentialSubject getCredentialSubject(CredentialContext context) {
        // not needed for this simple example
        return null;
    }

    @Override
    public CredentialContext getCredentialContext() {
        // not needed for this simple example
        return null;
    }

    @Override
    public Provider getProvider() {
        // not needed for this simple example
        return null;
    }
}