import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.UsernamePasswordAuthenticationToken;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialException;
import javax.security.auth.UnknownCredentialException;
import javax.security.auth.message.MessageException;
import java.util.HashMap;
import java.util.Map;

public class java_38196_CredentialValidator_A07 implements CredentialValidator {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    private static final Map<String, String> VALID_USERS = new HashMap<>();

    static {
        VALID_USERS.put("user", "password");
        VALID_USERS.put("admin", "admin");
    }

    @Override
    public Subject validate(Subject subject, Credential credential, CallbackHandler callbackHandler)
            throws CredentialException, LoginException {
        if (credential instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken usernamePasswordToken = (UsernamePasswordAuthenticationToken) credential;
            String username = usernamePasswordToken.getIdentifier();
            String password = new String(usernamePasswordToken.getCredentials());

            if (!username.equals(USERNAME) || !PASSWORD.equals(password)) {
                throw new UnknownCredentialException("Invalid username or password");
            }
        }

        return subject;
    }
}