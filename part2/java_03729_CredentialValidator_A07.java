import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;
import javax.security.auth.Subject;

public class java_03729_CredentialValidator_A07 implements CredentialValidator {

    private Credential credential;
    private Subject subject;

    public java_03729_CredentialValidator_A07() {
        this.credential = null;
        this.subject = null;
    }

    @Override
    public void validate(CredentialContext context) throws CredentialNotFoundException, LoginException {
        // Check if the credential is already set
        if (this.credential != null) {
            throw new IllegalStateException("Credential already set");
        }

        // Set the credential
        this.credential = context.getCredential();

        // Check if the subject is already set
        if (this.subject != null) {
            throw new IllegalStateException("Subject already set");
        }

        // Set the subject
        this.subject = context.getSubject();

        // Check if the authentication is successful
        if (!context.authenticate(false)) {
            throw new LoginException("Authentication failed");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CredentialValidator) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}