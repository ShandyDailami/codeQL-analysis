import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.AuthenticationException;

public class java_39568_CredentialValidator_A08 implements CallbackHandler {

    @Override
    public java.security.Authentication getAuthentication() throws AuthenticationException {
        Subject subject = Subject.getSubject(true);

        // Add the user and roles here
        subject.getPrincipal().getAttributes().put("username", "user");
        subject.getPrincipal().getAttributes().put("password", "password");

        return subject;
    }

    @Override
    public java.security.Authentication getAuthentication(CallbackHandler callbackHandler) throws AuthenticationException, UnsupportedCallbackException {
        return getAuthentication();
    }

}