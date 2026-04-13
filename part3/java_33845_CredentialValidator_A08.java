import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.spi.LoginModule;
import java.security.AccessControlContext;
import java.security.Guard;
import java.util.Iterator;

public class java_33845_CredentialValidator_A08 implements LoginModule {

    private Subject subject;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, AccessControlContext context) {
        this.subject = subject;
    }

    @Override
    public Guard authenticate(String username, String password) {
        if (username.equalsIgnoreCase("admin") && password.equals("password")) {
            return new Guard() {
                @Override
                public boolean implies(Subject subject) {
                    return true;
                }
            };
        } else {
            return null;
        }
    }
}

public class CustomCallbackHandler implements CallbackHandler {

    @Override
    public boolean getRequestedPassword(char[] chars) {
        return false;
    }

    @Override
    public void handle(char[] chars) {

    }

    @Override
    public void cleanup(Subject subject) {

    }
}

public class CustomLoginContext extends LoginContext {

    public java_33845_CredentialValidator_A08(Subject subject, CallbackHandler callbackHandler, AccessControlContext context) throws Exception {
        super(subject, callbackHandler, context);
    }

    public static void main(String[] args) throws Exception {
        Subject subject = new Subject.PublicKeySubject(null);
        CallbackHandler callbackHandler = new CustomCallbackHandler();
        AccessControlContext context = new AccessControlContext();

        CustomLoginContext loginContext = new CustomLoginContext(subject, callbackHandler, context);
        loginContext.login();
    }
}