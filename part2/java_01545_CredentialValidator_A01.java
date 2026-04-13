import java.security.cert.X509Certificate;

import javax.naming.AuthenticationException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

import sun.security.x509.X509Subject;

public class java_01545_CredentialValidator_A01 implements CredentialValidator {

    private CallbackHandler handler;

    public java_01545_CredentialValidator_A01(CallbackHandler handler) {
        this.handler = handler;
    }

    public Object getCredentials(Callback[] callbacks) throws AuthenticationException, UnsupportedCallbackException, LoginException {
        if (handler != null) {
            handler.handle(callbacks);
        }
        return null;
    }

    public X509Certificate[] getCertificates(Callback[] callbacks) throws AuthenticationException, UnsupportedCallbackException, LoginException {
        if (handler != null) {
            handler.handle(callbacks);
        }
        return null;
    }

    public X509Subject getSubject(Callback[] callbacks) throws AuthenticationException, UnsupportedCallbackException, LoginException {
        if (handler != null) {
            handler.handle(callbacks);
        }
        return null;
    }

    public boolean validate(Callback[] callbacks) throws LoginException, AuthenticationException, UnsupportedCallbackException {
        if (handler != null) {
            handler.handle(callbacks);
        }
        return true;
    }

    public void setCallbackHandler(CallbackHandler handler) {
        this.handler = handler;
    }

    public CallbackHandler getCallbackHandler() {
        return handler;
    }

}