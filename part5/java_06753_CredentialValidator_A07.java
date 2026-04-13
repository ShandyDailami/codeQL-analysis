import javax.security.auth.callback.*;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.login.LoginException;
import java.security.Principal;

public class java_06753_CredentialValidator_A07 implements CredentialValidator {

    public UsernamePasswordAuthenticationToken validate(CallbackHandler callbackHandler) throws LoginException {
        UsernamePasswordAuthenticationToken token = null;
        try {
            PasswordAuthenticationToken callbackToken = (PasswordAuthenticationToken) callbackHandler.getCallbackToken();
            String password = callbackToken.getCredentials().toString();
            if ("admin".equals(callbackToken.getPrincipal()) && "password".equals(password)) {
                token = new UsernamePasswordAuthenticationToken(callbackToken.getPrincipal(), callbackToken.getCredentials(), new PrincipalCollection());
            } else {
                throw new LoginException("Authentication failed");
            }
        } catch (CallbackException e) {
            throw new LoginException(e.getMessage());
        }
        return token;
    }
}