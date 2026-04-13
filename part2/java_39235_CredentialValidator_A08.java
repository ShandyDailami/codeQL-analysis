import javax.security.auth.Subject;
import javax.security.auth.password.PasswordChangeAllowed;
import javax.security.auth.password.PasswordResetAllowed;
import javax.security.auth.message.AuthException;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;

public class java_39235_CredentialValidator_A08 implements javax.security.auth.CredentialValidator {

    @Override
    public CredentialValidationResult validate(Credential credential) throws LoginException {
        String username = credential.getUsername();
        char[] password = credential.getPassword();
        
        // Check if the username is 'admin' and the password is 'admin'
        if ("admin".equals(username) && "admin".equals(new String(password))) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.INVALID;
        }
    }

    @Override
    public boolean getAcceptedDomain(String arg0) {
        // This method is not used here, but it must be implemented in order to be a valid CredentialValidator
        return false;
    }

    @Override
    public boolean getAcceptedIssuer(String arg0) {
        // This method is not used here, but it must be implemented in order to be a valid CredentialValidator
        return false;
    }

    @Override
    public boolean getAcceptedType(String arg0) {
        // This method is not used here, but it must be implemented in order to be a valid CredentialValidator
        return false;
    }

    @Override
    public Subject getSubject(String arg0) throws LoginException {
        // This method is not used here, but it must be implemented in order to be a valid CredentialValidator
        return null;
    }
}