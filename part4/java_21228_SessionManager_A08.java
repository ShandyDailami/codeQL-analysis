import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

public class java_21228_SessionManager_A08 {

    private Subject subject;
    private CallbackHandler callbackHandler;

    public java_21228_SessionManager_A08(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    public void validateUser(String username, String password) throws LoginException {
        subject = Subject.getSubject(callbackHandler, username, password);
        if (subject.getPrincipals().size() == 0) {
            throw new LoginException("Invalid credentials");
        }
    }

    public Subject getSubject() {
        return subject;
    }
}