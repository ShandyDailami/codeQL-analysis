import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x50.X50Principal;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import java.security.Principal;
import java.security.cert.CertificateException;

public class java_26203_CredentialValidator_A03 implements javax.security.auth. credential.CredentialValidator {

    public Credential validate(Subject subject, Credential credential) {
        return validate(subject, credential);
    }

    public Credential validate(Subject subject, Credential credential, CallbackHandler callbackHandler) {
        return null;
    }

    public Credential validate(Subject subject, Credential credential, Principal[] principals, Object候选) {
        return null;
    }

    public Credential validate(Subject subject, Credential credential, Principal[] principals, Object candidate, CallbackHandler callbackHandler, String authType) throws LoginException, CertificateException {
        return null;
    }

    public Credential validate(Subject subject, Credential credential, Principal[] principals, Object candidate, CallbackHandler callbackHandler, String authType, X509Certificate[] certificates) throws LoginException, CertificateException {
        return null;
    }

    public Credential validate(Subject subject, Credential credential, Principal[] principals, Object candidate, CallbackHandler callbackHandler, String authType, X509Certificate[] certificates, X500Principal x500Principal) throws LoginException, CertificateException {
        return null;
    }

}