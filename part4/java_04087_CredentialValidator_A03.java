import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.destination.Destination;
import javax.security.auth.username.UsernamePasswordCredential;
import javax.security.auth.x500.X500Principal;

public class java_04087_CredentialValidator_A03 implements javax.security.auth.CredentialValidator {

    @Override
    public Credential validate(Subject subject) throws IllegalArgumentException {
        // check if username and password matches
        if ("admin".equals(subject.getPrincipal().getName()) && "password".equals(subject.getPrincipal().getPassword())) {
            return new UsernamePasswordCredential("admin", "password");
        }
        return null;
    }

    @Override
    public boolean getRequestedAuthMethods() {
        return false;
    }

    @Override
    public Destination getRequestedDestination() {
        return null;
    }

    @Override
    public X500Principal getRequestedPrincipal() {
        return null;
    }

    @Override
    public void setCallbackHandler(CallbackHandler callbackHandler) {
        // not used
    }

    @Override
    public void validate(Subject subject, CallbackHandler callbackHandler, Destination destination, X500Principal principal) throws UnsupportedCallbackException {
        // not used
    }
}