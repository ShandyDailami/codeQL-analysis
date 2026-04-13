import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.Iterator;

public class java_08391_CredentialValidator_A01 implements LoginModule {

    private String username;
    private String password;
    private CallbackHandler callbackHandler;

    public java_08391_CredentialValidator_A01(String username, String password, CallbackHandler callbackHandler) {
        this.username = username;
        this.password = password;
        this.callbackHandler = callbackHandler;
    }

    @Override
    public boolean validate(Subject subject, Principal principal) {
        if (principal != null) {
            subject.getPrincipals().add(principal);
        }
        if (subject.getPrincipals().size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator getPreviousCallHandlers() {
        return callbackHandler.getPreviousHandlers();
    }

    @Override
    public Iterator getCallHandlers() {
        return callbackHandler.getHandlers();
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Principal callingPrincipal) throws LoginException {
        this.callbackHandler = callbackHandler;
        if (callbackHandler != null) {
            callbackHandler.handle(new AuthCallback() {
                @Override
                public void handle(AuthToken arg0, Principal arg1) throws LoginException {
                    // do nothing
                }

                @Override
                public boolean commit() throws LoginException {
                    return true;
                }
            });
        }
    }

    @Override
    public void unload() {
        // do nothing
    }
}