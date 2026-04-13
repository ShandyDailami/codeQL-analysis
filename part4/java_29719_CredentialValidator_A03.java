import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialPermission;
import java.security.spec.Subject;

public class java_29719_CredentialValidator_A03 implements CredentialValidator {

    public java_29719_CredentialValidator_A03() {
        // Required empty public constructor
    }

    @Override
    public void validate(Credential credential) {
        // Here, we are checking if the credential is null or not
        if (credential == null) {
            throw new NullPointerException("Credential is null");
        }

        // Here, we are checking if the credential is a CredentialPermission
        if (!(credential instanceof CredentialPermission)) {
            throw new IllegalArgumentException("Credential is not a CredentialPermission");
        }

        // Check if the subject is valid
        Subject subject = credential.getSubject();
        if (subject == null) {
            throw new NullPointerException("Subject is null");
        }

        // Check if the principal is valid
        Principal principal = subject.getPrincipal();
        if (principal == null) {
            throw new NullPointerException("Principal is null");
        }

        // Check if the credential id valid
        String credentialId = credential.getID();
        if (credentialId == null || credentialId.isEmpty()) {
            throw new NullPointerException("Credential ID is null or empty");
        }

        // All checks passed, we can proceed with the authentication
        System.out.println("Credential is valid, proceeding with authentication");
    }
}