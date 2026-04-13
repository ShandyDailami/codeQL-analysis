import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialException;
import javax.security.auth.validation.AbstractLoginModule;

public class java_02518_CredentialValidator_A01 extends AbstractLoginModule {

    // A simple in-memory store of username/password pairs
    private Map<String, String> credentials = new HashMap<>();

    public java_02518_CredentialValidator_A01() {
        // Add some sample credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    protected String getCallerName(Subject subject) {
        return "user";
    }

    @Override
    protected String getPassword(Subject subject) {
        return credentials.get(getCallerName(subject));
    }

    @Override
    protected void validate(Subject subject, String password) throws CredentialException {
        if (password == null || !password.equals(getPassword(subject))) {
            throw new CredentialException("Invalid password");
        }
    }

    @Override
    public String getName() {
        return "CustomLoginModule";
    }
}