import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public class java_27138_CredentialValidator_A07 implements LoginModule {

    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map<String, String> userDatabase = new HashMap<>();

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, String> map) throws LoginException {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    @Override
    public boolean validate(Principal user, String password) throws LoginException {
        if (user == null || password == null || password.length() == 0) {
            return false;
        }

        String expectedPassword = userDatabase.get(user.getName());

        if (expectedPassword == null) {
            return false;
        }

        if (!password.equals(expectedPassword)) {
            return false;
        }

        return true;
    }
}