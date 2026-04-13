import org.jwt.algs.JWT;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import javax.security.auth.store.CredentialStore;
import javax.security.auth.store.CredentialStoreException;
import javax.security.auth.store.UsernamePasswordCredential;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

public class java_18121_CredentialValidator_A03 implements CredentialStore, CallbackHandler {

    private Set<Credential> credentials = new HashSet<>();

    @Override
    public Credential getCredential(Principal principal) throws CredentialStoreException {
        // In a real application, this would actually query your own database or similar
        for (Credential credential : credentials) {
            if (credential.getIdentifier().equals(principal.getName())) {
                return credential;
            }
        }
        return null;
    }

    @Override
    public CredentialStore.ValidationResult validate(Subject subject, Credential credential) {
        // In a real application, this would also query your own database or similar
        return CredentialStore.ValidationResult.VALID;
    }

    @Override
    public Credential thisUsernamePassword() {
        return new UsernamePasswordCredential("user", "password".toCharArray());
    }

    @Override
    public void setCallbackHandler(CallbackHandler callbackHandler) {
        // Not needed in this example
    }

    @Override
    public CredentialStore.ValidationResult validate(Subject subject, Credential credential, Principal principal) throws CredentialStoreException {
        // Not needed in this example
        return CredentialStore.ValidationResult.VALID;
    }

    @Override
    public void clearCallbackHandler() {
        // Not needed in this example
    }

    @Override
    public boolean commit() throws CredentialStoreException {
        // Not needed in this example
        return false;
    }

    @Override
    public void emptyCallbackHandler() {
        // Not needed in this example
    }

    @Override
    public boolean isCallerAnonymous() {
        // Not needed in this example
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        // Not needed in this example
        return false;
    }

    @Override
    public void login(Subject subject, String callerIdentity, Credential credential) throws LoginException, CredentialStoreException {
        // Not needed in this example
    }

    @Override
    public boolean logout(Subject subject, String callerIdentity) throws LoginException, CredentialStoreException {
        // Not needed in this example
        return false;
    }

    @Override
    public void store(Subject subject, String callerIdentity, Credential credential) throws CredentialStoreException {
        credentials.add(credential);
    }
}

public class JWTValidator implements javax.security.auth.credential.CredentialValidator {

    @Override
    public boolean validate(Subject subject, Credential credential) {
        try {
            JWT.decode(credential.getIdentifier());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean validate(Subject subject, Credential credential, Object settings) {
        // This method is not used in this example
        return false;
    }
}