import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlAction;
import java.security.AccessControlListener;
import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

public class java_38602_CredentialValidator_A01 implements CredentialValidator {

    private List<CallbackHandler> callbackHandlers = new ArrayList<>();
    private List<Callback> callbacks = new ArrayList<>();
    private AccessControlContext context;

    public java_38602_CredentialValidator_A01() {
        context = new AccessControlContext();
        context.getListener().addEventListener(new AccessControlListener() {
            @Override
            public void afterLogin(AccessControlContext accessControlContext,
                                  Object credentials,
                                  Subject subject) {
            }

            @Override
            public void validate(AccessControlContext accessControlContext,
                                Object credentials,
                                Subject subject) throws SecurityException {
                // BrokenAccessControl code here
            }
        });
    }

    @Override
    public boolean validate(Subject subject, Object credentials, AccessControlContext context) {
        return context.getListener().validate(subject, credentials, context);
    }

    @Override
    public void refresh() {
        // Not implemented
    }

    @Override
    public List<CallbackHandler> getCallbackHandlers() {
        return callbackHandlers;
    }

    @Override
    public void setCallbackHandler(CallbackHandler callbackHandler) {
        callbackHandlers.add(callbackHandler);
        callbacks.add(callbackHandler.getCallback());
    }

    @Override
    public List<Callback> getCallbacks() {
        return callbacks;
    }

    @Override
    public boolean getCredentials(Subject subject, Object[] details) throws UnsupportedCallbackException {
        // BrokenAccessControl code here
        return true;
    }

    @Override
    public boolean refreshCredentials(Subject subject, Object details) throws UnsupportedCallbackException {
        // BrokenAccessControl code here
        return true;
    }

    @Override
    public void removeCallback(Callback callback) {
        // Not implemented
    }

    @Override
    public void addCallback(Callback callback) {
        // Not implemented
    }
}