import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class java_16570_CredentialValidator_A03 implements LoginModule {

    private Map<String, String> credentials = new HashMap<>();

    public java_16570_CredentialValidator_A03() {
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    @Override
    public boolean validate(Subject subject, String username, String password) {
        return this.credentials.get(username).equals(password);
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, Object> map) throws LoginException {
        // No implementation needed here
    }
}