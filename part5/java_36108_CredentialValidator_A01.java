import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

public class java_36108_CredentialValidator_A01 implements CallbackHandler {

    @Override
    public void handle(Callback callback) throws UnsupportedCallbackException, LoginException {
        // we just ignore the callbacks for now
    }

    public Subject doAuthentication(String user, String password) {
        // here we simulate a user is authenticated
        // we return a dummy subject for now
        return new Subject.Builder().build();
    }
}