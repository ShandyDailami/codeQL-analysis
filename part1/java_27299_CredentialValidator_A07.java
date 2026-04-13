import java.security.cert.X509Certificate;
import java.util.Base64;
import java.io.ByteArrayInputStream;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509CertificateImpl;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.xauth.XAUTHInfo;
import java.security.KeyStore;
import java.security.KeyStoreException;
import javax.security.auth.Subject;
import javax.security.auth.message.AuthStatus;
import javax.security.auth.message.AuthException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;

public class java_27299_CredentialValidator_A07 implements CredentialValidator {

    // Credential validator implementation
    @Override
    public Credential validate(CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException, AuthException {
        // Retrieve the authentication info.
        XAUTHInfo authInfo = (XAUTHInfo) callbackHandler.getRequestedAuthInfo("XAUTH");
        AuthStatus authStatus = authInfo.validate(new Subject());

        // If the authentication failed, return null.
        if (authStatus.getStatusCode() != AuthStatus.SUCCESS) {
            return null;
        }

        // Otherwise, construct a credential object.
        String username = authInfo.getUserName();
        String password = new String(Base64.getDecoder().decode(authInfo.getPassword()));
        return new UsernamePasswordCredential(username, password);
    }

    // CredentialValidator interface implementation
    @Override
    public void validate(Credential credential, CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException, AuthException {
        validate(callbackHandler);
    }
}