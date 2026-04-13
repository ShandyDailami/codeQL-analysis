import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_34109_CredentialValidator_A01 implements CallbackHandler {

    private List<CallbackHandler> delegates;

    public java_34109_CredentialValidator_A01() {
        delegates = new ArrayList<>();
    }

    public void addDelegate(CallbackHandler delegate) {
        delegates.add(delegate);
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean handleMessage(String message) throws LoginException, IOException {
        return false;
    }

    @Override
    public boolean handleMessage(Callback[] callbacks) throws LoginException {
        for (Callback callback : callbacks) {
            if (!process(callback)) {
                return false;
            }
        }
        return true;
    }

    private boolean process(Callback callback) throws LoginException {
        if (callback instanceof UsernamePasswordCallback) {
            UsernamePasswordCallback callbackUI = (UsernamePasswordCallback) callback;

            callbackUI.setRequestedPassword("");
            callbackUI.setPrompt("Enter password for user " + callbackUI.getID());

            if (!delegates.isEmpty()) {
                delegates.get(0).handle(callbackUI);
            } else {
                callbackUI.setPassword("");
            }

            return true;
        }

        return false;
    }
}