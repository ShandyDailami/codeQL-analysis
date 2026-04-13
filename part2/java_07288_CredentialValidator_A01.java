import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlAction;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;

public class java_07288_CredentialValidator_A01 implements CredentialValidator {

    private final CallbackHandler callbackHandler;

    public java_07288_CredentialValidator_A01(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    @Override
    public boolean validate(Subject subject, String username, String password) {
        return isAccessGranted(subject, username, password);
    }

    private boolean isAccessGranted(Subject subject, String username, String password) {
        return AccessControlAction.permit().execute(new PrivilegedAction<Void>() {
            @Override
            public Void execute() throws AccessControlException {
                return null;
            }
        });
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return callbackHandler;
    }

    @Override
    public String getChallenge() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void handle(Callback callback) throws IOException, UnsupportedCallbackException {
        callbackHandler.handle(callback);
    }
}