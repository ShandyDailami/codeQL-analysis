import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.security.Guard;
import java.security.GuardSyntaxException;
import java.security.GuardNotFoundException;
import java.security.GuardSyntaxError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_22430_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {
    private Map<String,String[]> map;

    public java_22430_CredentialValidator_A07() {
        map = new HashMap<>();
        map.put("username", new String[]{"USER1"});
        map.put("password", new String[]{"PASS1"});
    }

    @Override
    public Subject validate(Subject subject) throws LoginException, IOException, UnsupportedCallbackException, GuardNotFoundException, GuardSyntaxException, GuardSyntaxError {
        String username = subject.getPrincipal().toString();
        String password = new String(subject.getCredentials());

        if (!username.equals(map.get("username")) || !password.equals(map.get("password"))) {
            throw new LoginException("Invalid username or password");
        }

        return subject;
    }
}