import java.security.cert.X509Certificate;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamePasswordAuthentication.UsernamePasswordAuthenticationStatus;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.mechanism.callback.AppSpecificCallback;
import javax.security.auth.mechanism.callback.CallbackState;
import javax.security.auth.mechanism.callback.UnsupportedCallbackException;
import javax.security.auth.mechanism.callback.StateCallback;
import javax.security.auth.mechanism.callback.StateCallbackHandler;
import javax.security.auth.mechanism.callback.StateRequestCallback;
import javax.security.auth.mechanism.callback.StateRequestState;
import javax.security.auth.mechanism.callback.StateRequestStateHandler;

public class java_05561_CredentialValidator_A03 implements CallbackHandler {
    @Override
    public Credential getCredential(CallbackHandler callbackHandler)
            throws UnsupportedCallbackException {
        return null;
    }

    @Override
    public Credential getCredential(Callback[] callbacks)
            throws UnsupportedCallbackException {
        return null;
    }

    @Override
    public Principal getPrincipal(CallbackHandler callbackHandler) {
        return null;
    }

    @Override
    public Principal getPrincipal(Callback[] callbacks) {
        return null;
    }
}

public class CustomStateCallback implements StateCallback {
    @Override
    public StateRequestState getStateRequestState(CallbackHandler callbackHandler)
            throws UnsupportedCallbackException {
        return null;
    }

    @Override
    public StateRequestState getStateRequestState(Callback[] callbacks)
            throws UnsupportedCallbackException {
        return null;
    }

    @Override
    public StateRequestStateHandler getStateRequestStateHandler(CallbackHandler callbackHandler) {
        return null;
    }

    @Override
    public StateRequestStateHandler getStateRequestStateHandler(Callback[] callbacks) {
        return null;
    }
}

public class CustomCallback implements Callback {
    private String username = null;
    private String password = null;

    public java_05561_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void challenge(String s) throws UnsupportedCallbackException {
        // Not implemented
    }

    @Override
    public void callback(String s) throws UnsupportedCallbackException {
        // Not implemented
    }

    @Override
    public void state(String s) throws UnsupportedCallbackException {
        // Not implemented
    }

    @Override
    public void status(String s) throws UnsupportedCallbackException {
        // Not implemented
    }

    @Override
    public void response(String s) throws UnsupportedCallbackException {
        // Not implemented
    }
}

public class CustomStateCallbackHandler implements StateCallbackHandler {
    @Override
    public StateRequestState getStateRequestState(String s)
            throws UnsupportedCallbackException {
        return null;
    }

    @Override
    public StateRequestStateHandler getStateRequestStateHandler()
            throws UnsupportedCallbackException {
        return null;
    }

    @Override
    public void setCallbackHandler(CallbackHandler callbackHandler)
            throws UnsupportedCallbackException {
        // Not implemented
    }

    @Override
    public void handle(Callback[] callbacks, StateRequestState[] states)
            throws UnsupportedCallbackException {
        // Not implemented
    }

    @Override
    public void setRequestState(StateRequestState[] stateRequestStates)
            throws UnsupportedCallbackException {
        // Not implemented
    }
}

public class CustomAppSpecificCallback extends AppSpecificCallback {
    @Override
    public void setRequestState(StateRequestState[] stateRequestStates)
            throws UnsupportedCallbackException {
        // Not implemented
    }

    @Override
    public void state(StateRequestState stateRequestState)
            throws UnsupportedCallbackException {
        // Not implemented
    }

    @Override
    public void challenge(String string) throws UnsupportedCallbackException {
        // Not implemented
    }

    @Override
    public void response(String string) throws UnsupportedCallbackException {
        // Not implemented
    }

    @Override
    public void status(String string) throws UnsupportedCallbackException {
        // Not implemented
    }
}