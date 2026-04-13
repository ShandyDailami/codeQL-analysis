import javax.security.auth.CredentialValidator;
import javax.security.auth.LoginException;
import javax.security.auth.UnknownAccountException;
import javax.security.auth.message.AuthException;
import javax.security.auth.message.MessageContext;

public class java_26020_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public boolean validate(MessageContext messageContext) throws LoginException, AuthException, UnknownAccountException {
        // This is a simple check for the user's username
        String userName = messageContext.getCallerPrincipal().getName();
        if ("admin".equals(userName)) {
            return true;
        } else {
            throw new UnknownAccountException("Unknown account");
        }
    }
}