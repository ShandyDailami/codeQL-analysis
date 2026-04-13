import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_39563_CredentialValidator_A07 implements javax.security.auth.login.LoginModule {

    // Hardcoded username and password
    private final String hardcodedUsername = "admin";
    private final String hardcodedPassword = "password";

    private List<CallbackHandler> callbackHandlers = new ArrayList<>();
    private Subject subject;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, String arg2) throws IOException, UnsupportedCallbackException {
        this.subject = subject;
        this.callbackHandlers.add(callbackHandler);
    }

    @Override
    public boolean authenticate(String arg0, String arg1) {
        boolean success = arg0.equals(hardcodedUsername) && arg1.equals(hardcodedPassword);
        return success;
    }

    @Override
    public boolean commit() throws IOException, UnsupportedCallbackException {
        return true;
    }

    @Override
    public boolean abort(Subject subject, String arg1) throws IOException, UnsupportedCallbackException {
        return true;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            callback.handle(new NameValuePair[] { new NameValuePair("UserName", subject.getPrincipal().getName()) });
        }
    }

    @Override
    public Subject getSubject() throws IllegalStateException {
        return subject;
    }
}