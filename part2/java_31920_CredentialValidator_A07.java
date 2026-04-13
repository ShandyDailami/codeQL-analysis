import java.util.HashMap;
import java.util.Map;

import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;

public class java_31920_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials = new HashMap<>();

    public java_31920_CredentialValidator_A07() {
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean validate(String callerPrincipal, String password) {
        if (credentials.containsKey(callerPrincipal) && 
            credentials.get(callerPrincipal).equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public void reset() {
        // Nothing to do
    }
}