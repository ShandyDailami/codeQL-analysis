import javax.security.auth.Credential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_37668_CredentialValidator_A07 implements CallbackHandler {

    private final Set<String> acceptedDomains = new HashSet<>(Arrays.asList("example.com", "another.example.com"));

    @Override
    public CredentialValidationResult validate(Callback callback) throws AccessControlException {
        String domain = null;
        callback.put(Callback.OUTPUT_DOMAIN, domain);

        if (domain == null) {
            throw new AccessControlException("No domain value was passed to the callback");
        }

        if (acceptedDomains.contains(domain)) {
            return new CredentialValidationResult("Success", null, null);
        } else {
            return new CredentialValidationResult("Failure", null, null);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyCallbackHandler callbackHandler = new MyCallbackHandler();
        // This should throw an exception as "test.example.com" is not in the accepted list
        callbackHandler.validate(new Callback() {
            @Override
            public void put(String s, Object o) {
                // No-op
            }
        });
    }
}