import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.Callback;
import javax.security.auth.UsernamePasswordCallback;
import javax.security.auth.login.LoginException;

public class java_15695_CredentialValidator_A07 implements CallbackHandler {

    @Override
    public void handle(Callback callback) throws LoginException {
        UsernamePasswordCallback callbackObj = (UsernamePasswordCallback) callback;

        Subject subject = callback.getSubject();
        String username = callbackObj.getIdentifier();
        String password = new String(callbackObj.getPassword());

        if ("user".equals(username) && "password".equals(password)) {
            // Authentication successful, set the callback to null
            callbackObj.setPassword(null);
            subject.authenticate(callback);
        } else {
            // Authentication failed, set the callback to null
            callbackObj.setPassword(null);
            throw new LoginException("Invalid username or password");
        }
    }
}