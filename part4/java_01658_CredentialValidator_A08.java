import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public class java_01658_CredentialValidator_A08 implements LoginModule {

    private Map<String, String> credentials = new HashMap<>();

    public java_01658_CredentialValidator_A08() {
        // Mock credentials
        this.credentials.put("admin", "admin");
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> options) {
        // No need to initialize this module
    }

    @Override
    public boolean validate(Subject subject, String callerPrincipal, Object callingPrincipal, Map<String, Object> options) {
        // If the user's name is 'admin' and the password is 'admin', return true
        return ((String)callingPrincipal).equals(callerPrincipal)
            && ((String)callingPrincipal).equals(credentials.get(callerPrincipal));
    }
}