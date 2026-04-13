import java.security.cert.X509Certificate;
import java.security.KeyStore;
import javax.security.auth.x500.X500Principal;
import java.util.Collection;
import java.util.Collections;

import javax.security.auth.CredentialValidator;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamePasswordAuth.PasswordAuthentication;

public class java_12991_CredentialValidator_A08 implements CredentialValidator {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(CallbackHandler callbackHandler)
            throws UnsupportedCallbackException {
        Callback[] callbacks = callbackHandler.getCallbacks();
        if (callbacks.length != 2) {
            throw new IllegalArgumentException("Expecting 2 callbacks");
        }
        for (Callback callback : callbacks) {
            if (callback instanceof PasswordAuthentication) {
                PasswordAuthentication passwordAuthentication = (PasswordAuthentication) callback;
                String username = passwordAuthentication.getUserName();
                String password = new String(passwordAuthentication.getPassword());
                if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Collection<X509Certificate> getAcceptedIssuers() {
        return Collections.emptySet();
    }

}