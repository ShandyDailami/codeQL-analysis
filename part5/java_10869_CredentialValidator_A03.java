import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.spi.AuthProvider;
import javax.security.auth.spi.ServiceException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_10869_CredentialValidator_A03 implements AuthProvider {
    private Map<String, String> credentials = new HashMap<>();

    public java_10869_CredentialValidator_A03() {
        this.credentials.put("alice", "password1");
        this.credentials.put("bob", "password2");
    }

    @Override
    public Subject authenticate(Subject subject, String username, String password) throws ServiceException, IOException, UnsupportedCallbackException {
        if (!credentials.containsKey(username) || !credentials.get(username).equals(password)) {
            throw new ServiceException("Authentication failed");
        }
        return subject;
    }

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler, Map<String, Object> map) throws IOException, UnsupportedCallbackException, ServiceException {
        return false;
    }

    @Override
    public boolean supports(String authenticationMethod) {
        return "example".equals(authenticationMethod);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.supports("example")); // Should print: true
        System.out.println(validator.authenticate(null, "alice", "password1")); // Should print: Successful authentication
        System.out.println(validator.authenticate(null, "alice", "wrong_password")); // Should print: Authentication failed
    }
}