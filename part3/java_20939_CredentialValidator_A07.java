import java.security.AuthFailureException;
import java.security.AuthenticationException;
import java.security.credential.Credential;
import java.security.credential.CredentialNotFoundException;
import java.security.credential.CredentialUsage;

public class java_20939_CredentialValidator_A07 implements CredentialValidator {

    // This is a simple example. In a real implementation, you would probably use a more complex method
    // to verify the user's password.
    private boolean authenticate(String password) {
        // Here you would perform the authentication logic. In a real implementation, you should never store passwords in plain text.
        // This is a simple example, just to show the concept.
        return password.equals("realpassword");
    }

    @Override
    public boolean validate(Credential credential, String password)
            throws CredentialNotFoundException, AuthenticationException, AuthFailureException {
        if (credential == null) {
            throw new CredentialNotFoundException("No Credential found");
        }

        if (!(credential instanceof Credential.UsernamePasswordCredential)) {
            throw new AuthFailureException("Credential type is not supported.");
        }

        return authenticate(password);
    }

    @Override
    public boolean getUsage(Credential credential) {
        if (credential == null) {
            return false;
        }

        if (!(credential instanceof Credential.UsernamePasswordCredential)) {
            return false;
        }

        return true;
    }
}