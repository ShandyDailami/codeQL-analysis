import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_18324_CredentialValidator_A08 implements CallbackHandler {
    private Map<String, String> credentials;

    public java_18324_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler, Map<String, Object> map) throws IOException, LoginException, UnsupportedCallbackException {
        // No real implementation required
        return null;
    }

    @Override
    public CredentialValidationResult validate(Callback callback, Object authenticationId) throws IOException, LoginException, UnsupportedCallbackException {
        String username = callback.getSubject();
        if (credentials.containsKey(username)) {
            String password = new String(Base64.getDecoder().decode(credentials.get(username)));
            if (password.equals(new String((byte[]) callback.getCredentials()))) {
                return new CredentialValidationResult("Success", "Authentication Successful");
            }
        }
        return new CredentialValidationResult("Failure", "Invalid Username/Password");
    }
}