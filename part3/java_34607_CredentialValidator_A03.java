import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.security.AccessControlException;

public class java_34607_CredentialValidator_A03 implements CallbackHandler {

    private static class MySubject implements Subject {
        @Override
        public boolean authenticate(Subject subject, String password) throws AccessControlException {
            return "user".equals(subject.getPrincipal()) && "password".equals(password);
        }
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return this;
    }

    @Override
    public boolean handle(Callback callback) throws LoginException, java.io.IOException, AccessControlException {
        UsernamePasswordCallback callbackObj = (UsernamePasswordCallback) callback;
        if (new MySubject().authenticate(Subject. anonymous(), callbackObj.getPasswordAsString())) {
            callbackObj.setRequestedPassword("***********");
            return true;
        }
        return false;
    }
}