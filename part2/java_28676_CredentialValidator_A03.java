import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.password.CredentialValidator;
import javax.security.auth.password.PasswordChangeException;
import javax.security.auth.password.PasswordRequiresChangeException;
import javax.security.auth.login.LoginException;

public class java_28676_CredentialValidator_A03 implements CredentialValidator {

    // Username and password data
    private Map<String, String> creds = new HashMap<>();

    public java_28676_CredentialValidator_A03() {
        creds.put("user1", "password1");
        creds.put("user2", "password2");
        creds.put("user3", "password3");
    }

    @Override
    public String getPassword(String user) {
        return creds.get(user);
    }

    @Override
    public String getCallerPrincipal(String password) {
        return null;
    }

    @Override
    public String getAuthID(String message, String callerPrincipal) {
        return null;
    }

    @Override
    public Subject getSubject(String arg0) throws LoginException {
        return null;
    }

    @Override
    public void validate(String arg0) throws LoginException {
        // Validation logic goes here.
    }

    @Override
    public boolean equals(Object arg0) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getPassword(String user, String message, String callerPrincipal) throws LoginException {
        return getPassword(user);
    }

    @Override
    public String getAuthID(String message, String callerPrincipal, String salt) throws LoginException {
        return getAuthID(message, callerPrincipal);
    }

    @Override
    public boolean requiresUserDetailsLookup() {
        return false;
    }

    @Override
    public boolean passwordChangeAllowed() {
        return false;
    }

    @Override
    public boolean passwordEquals(String user, String password) throws LoginException {
        return password.equals(getPassword(user));
    }

    @Override
    public boolean passwordRequiresChange() {
        return false;
    }
}