import javax.security.auth.CredentialValidator;
import javax.security.auth.LoginException;
import javax.security.auth.message.AuthStatus;
import javax.security.auth.message.MessageException;

public class java_31152_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public String validate(javax.security.auth.credential.Credential credential) throws MessageException, LoginException {
        String username = credential.getRequestingPrincipal().getName();
        String password = new String(credential.getCredentialIdentifier());
        
        if ("user".equals(username) && "pass".equals(password)) {
            return AuthStatus.OK.toString();
        } else {
            throw new LoginException("Authentication failed.");
        }
    }
}