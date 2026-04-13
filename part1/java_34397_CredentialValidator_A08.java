import java.security.Credential;
import java.security.AccessControlException;

public class java_34397_CredentialValidator_A08 {
    public boolean validateCredentials(Credential credential) {
        // Check if the credential is null
        if (credential == null) {
            throw new AccessControlException("Null credential is not allowed");
        }

        // Check if the credential is expired
        if (credential.isExpired(null)) {
            throw new AccessControlException("Expired credential is not allowed");
        }

        // Check if the credential is not active
        if (!credential.isActive()) {
            throw new AccessControlException("Inactive credential is not allowed");
        }

        // If all checks pass, the credentials are valid
        return true;
    }
}