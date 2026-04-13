import java.security.GeneralSecurityException;
import java.security.Principal;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

public class java_14833_CredentialValidator_A07 implements javax.security.auth.login.LoginModule {

    private String user = null;
    private String password = null;

    public java_14833_CredentialValidator_A07() {
        super();
    }

    public void initialize(Subject subject, CallbackHandler callbackHandler,
            Map sharedState, Map options) throws IOException,
            GeneralSecurityException {
        // no-op
    }

    public boolean commit(Subject subject) throws LoginException,
            IOException, GeneralSecurityException {
        return validate(subject);
    }

    public boolean validate(Subject subject) throws LoginException,
            IOException, GeneralSecurityException {
        Principal principal = subject.getPrincipal();
        String name = principal.getName();
        if (name.equals("user")) {
            return true;
        }
        return false;
    }

    public boolean abort(Subject subject, IOException ex) throws LoginException,
            GeneralSecurityException {
        return false;
    }

}