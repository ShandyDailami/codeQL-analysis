import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.AuthenticationException;
import java.security.GuardedBy;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.PasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;

public class java_24166_CredentialValidator_A08 implements CredentialValidator {

    private static final List<String> COMPLEX_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    private final KeyStore keyStore;
    private final Key key;
    private final CallbackHandler callbackHandler;

    public java_24166_CredentialValidator_A08(KeyStore keyStore, Key key, CallbackHandler callbackHandler) {
        this.keyStore = keyStore;
        this.key = key;
        this.callbackHandler = callbackHandler;
    }

    @Override
    public CredentialValidationResult validate(Credential credential) throws AccessDeniedException, LoginException {
        PasswordCredential passwordCredential = (PasswordCredential) credential;
        String password = passwordCredential.getPassword();

        if (COMPLEX_PASSWORDS.contains(password)) {
            return CredentialValidationResult.invalidate("Password is found in the known complex passwords list");
        }

        return CredentialValidationResult.success();
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return callbackHandler;
    }
}