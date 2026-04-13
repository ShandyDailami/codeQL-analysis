import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.GuardedBy;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.util.Map;

public class java_19146_CredentialValidator_A08 implements CredentialValidator {

    @GuardedBy("this.credentials")
    private Map<String, Credential> credentials;

    public java_19146_CredentialValidator_A08() {
        credentials = new java.util.concurrent.ConcurrentHashMap<>();
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                           Map<String, Credential> map) throws IOException,
            UnsupportedCallbackException {
        this.credentials = map;
    }

    @Override
    public boolean validate(Subject subject, CallbackHandler callbackHandler,
                           Credential credential) throws AccessDeniedException,
            AuthenticationException {
        try {
            if (credential instanceof UsernamePasswordCredential) {
                UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
                String username = usernamePasswordCredential.getIdentifier();
                char[] password = usernamePasswordCredential.getPassword();
                // Check if the provided username and password match a credential in the map
                if (credentials.containsKey(username) && credentials.get(username).getPassword().equals(new String(password))) {
                    return true;
                }
            } else if (credential instanceof PrivateKeyCredential) {
                PrivateKeyCredential privateKeyCredential = (PrivateKeyCredential) credential;
                PrivateKey privateKey = (PrivateKey) privateKeyCredential.getPrivateKey();
                // Verify the signature of the private key using the public key from the credential
                if (privateKeyCredential.getSignature().verify(privateKey)) {
                    return true;
                }
            } else {
                throw new UnsupportedCallbackException("Credential type not supported: " + credential.getClass().getName());
            }
        } catch (AccessControlException | SignatureException | IOException | IllegalArgumentException e) {
            throw new AccessDeniedException("Access denied", e);
        }
        return false;
    }
}