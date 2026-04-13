import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.security.GuardedBy;
import java.security.Principal;

public class java_40522_CredentialValidator_A01 implements javax.security.auth.credential.CredentialValidator {

    @GuardedBy("this.callbacks")
    private final CallbackHandler callbacks = new CallbackHandler() {
        public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
            // Do nothing, as we're always returning true.
        }
    };

    public Subject validate(Subject subject) throws LoginException {
        return subject;
    }
}