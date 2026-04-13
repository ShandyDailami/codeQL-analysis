import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AuthenticationException;
import java.security.GuaranteedAccessException;
import java.util.HashMap;
import java.util.Map;

public class java_12133_CredentialValidator_A07 implements LoginModule {
    private Map<String, String> credentials = new HashMap<>();

    @Override
    public boolean validate(Subject subject, String callerQualifiedName, Object pwd) throws AuthenticationException {
        // Simulate a login
        if (callerQualifiedName.equals("JohnDoe")) {
            credentials.put("username", "JohnDoe");
            credentials.put("password", "johnDoePassword");
            return true;
        }
        return false;
    }

    @Override
    public boolean commit() throws AuthenticationException, GuaranteedAccessException {
        return true;
    }

    @Override
    public void abort(Subject subject, String action, AuthenticationException ex) throws IllegalArgumentException, GuaranteedAccessException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean supports(String option) {
        return false;
    }

    @Override
    public boolean getCredentials(String callerQualifiedName, String[] requiredType, Object[] answers) throws AuthenticationException {
        if (callerQualifiedName.equals("JohnDoe")) {
            answers[0] = "johnDoePassword";
            return true;
        }
        return false;
    }

    @Override
    public boolean integrityCheck(String callerQualifiedName, String[] requiredType, Object[] answers) throws AuthenticationException {
        return false;
    }

    @Override
    public boolean getAccessGroup(String callerQualifiedName, String[] roleName, String[] roleDescription, String[] grantors, String[] attributeNames, String[] attributeValues) throws AuthenticationException {
        return false;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            @Override
            public void handle(Callback[] callbacks) throws IOException, AuthenticationException {
                throw new UnsupportedOperationException();
            }
        };
    }
}