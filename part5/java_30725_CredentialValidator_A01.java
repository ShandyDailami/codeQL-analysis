import java.security.InvalidParameterException;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.security.credential.Credential;
import java.security.credential.CredentialPermission;

public class java_30725_CredentialValidator_A01 {

    // Get the security provider.
    private Provider provider = Security.getProvider("LDAP");

    // Define the credential.
    private Credential credential;

    // Constructor.
    public java_30725_CredentialValidator_A01(Credential credential) {
        if (credential == null) {
            throw new InvalidParameterException("Credential must not be null");
        }
        this.credential = credential;
    }

    // Validate the credential.
    public boolean validate() {
        try {
            // Try to authenticate the credential.
            credential.validate(provider.getParameters());
            return true;
        } catch (GeneralSecurityException e) {
            // If there was a problem, return false.
            return false;
        }
    }
}