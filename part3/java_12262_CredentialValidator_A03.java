import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

public class java_12262_CredentialValidator_A03 implements CallbackHandler {

    private Map<String, String> passwordMap;

    public java_12262_CredentialValidator_A03() {
        passwordMap = new HashMap<>();
        passwordMap.put("password1", "password1");
        passwordMap.put("password2", "password2");
        passwordMap.put("password3", "password3");
    }

    @Override
    public String getCallerPrincipal() {
        return "user";
    }

    @Override
    public String getPassword(String s) throws IOException, AuthenticationException {
        return passwordMap.get(s);
    }

    @Override
    public void handle(Callback[] callbacks)
            throws IOException, UnsupportedCallbackException, AuthenticationException {
        // TODO Auto-generated method stub
    }

    @Override
    public Subject getSubject(String arg0, String arg1, Map arg2)
            throws IOException, AuthenticationException {
        // TODO Auto-generated method stub
        return null;
    }
}