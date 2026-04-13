import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_26330_CredentialValidator_A03 implements CredentialValidator {
    private Map<String, Credential> credentials;

    public java_26330_CredentialValidator_A03() {
        credentials = new HashMap<>();
        credentials.put("user1", new UsernamePasswordCredential("password1"));
        credentials.put("user2", new UsernamePasswordCredential("password2"));
    }

    @Override
    public CredentialValidationResult validate(CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException {
        Class<?>[] requestedAuthMethods = callbackHandler.getRequestedAuthMethods();
        if (requestedAuthMethods.length == 0) {
            return CredentialValidationResult.failure();
        }

        for (Class<?> authMethod : requestedAuthMethods) {
            if (authMethod == UsernamePasswordCredential.class) {
                UsernamePasswordCredential credential = new UsernamePasswordCredential();
                callbackHandler.get(credential);
                if (!Arrays.asList(credentials.keySet()).contains(credential.getIdentifier())) {
                    return CredentialValidationResult.failure();
                }
                if (!credential.getPassword().equals(credentials.get(credential.getIdentifier()).getPassword())) {
                    return CredentialValidationResult.failure();
                }
                return CredentialValidationResult.success();
            }
        }

        return CredentialValidationResult.failure();
    }
}