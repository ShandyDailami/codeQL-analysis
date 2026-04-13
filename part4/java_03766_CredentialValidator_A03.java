import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.username.UsernamePasswordCredential;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_03766_CredentialValidator_A03 implements CredentialValidator {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private Map<String, String> realUsers = new HashMap<>();

    public java_03766_CredentialValidator_A03() {
        realUsers.put("user1", "password1");
        realUsers.put("user2", "password2");
    }

    @Override
    public Credential validate(Subject subject, Credential credential) {
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentialIdentifier());

        if (realUsers.containsKey(username) && realUsers.get(username).equals(password)) {
            return new UsernamePasswordCredential(username, password);
        } else {
            return null;
        }
    }
}

public class CustomCallbackHandler implements CallbackHandler {
    @Override
    public Credential[] getCallableCredentials(Subject subject, String authenticationId, Map<String, Object> properties) {
        return new Credential[]{new UsernamePasswordCredential("", "")};
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    }
}