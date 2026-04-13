import java.security.GeneralSecurityException;
import java.security.Principal;
import java.util.Base64;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

import org.jboss.security.auth.UsernamePasswordCredentialValidation;
import org.jboss.security.auth.callback.UsernamePasswordCallback;
import org.jboss.security.auth.handler.UsernamePasswordHandler;

public class java_32262_CredentialValidator_A08 implements CallbackHandler {

    private final String username = "user";
    private final String password = "password";

    public boolean validate(Subject subject, String caller, Object appSpecificPayload,
                            CallbackHandler callbackHandler, Principal principal) throws LoginException, GeneralSecurityException {

        UsernamePasswordCallback callback = new UsernamePasswordCallback("", "");
        UsernamePasswordHandler handler = new UsernamePasswordHandler(callback, callbackHandler);
        callback.setPassword("");

        Subject newSubject = handler.validate(subject, caller, appSpecificPayload);

        if (newSubject == null) {
            throw new LoginException("Authentication failed");
        }

        String encodedCreds = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        UsernamePasswordCredentialValidation validation = new UsernamePasswordCredentialValidation();
        return validation.validate(newSubject, caller, appSpecificPayload);
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public void handle(Callback callback) throws UnsupportedCallbackException {
        throw new UnsupportedCallbackException(callback, "Unsupported callback");
    }
}