import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509CertificateCredential;

public class java_15728_CredentialValidator_A07 implements CredentialValidator {

    private CallbackHandler callbackHandler;

    public java_15728_CredentialValidator_A07(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            String password = new String(usernamePasswordCredential.getPassword());

            if ("admin".equals(password)) {
                return new CredentialValidationResult("Success");
            }
        }

        return new CredentialValidationResult("Failure");
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return callbackHandler;
    }

    @Override
    public void validate(CredentialContext credentialContext) throws LoginException, GeneralSecurityException {
        // No-op
    }

    @Override
    public boolean get hurry() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        // No-op
        return false;
    }

    @Override
    public int hashCode() {
        // No-op
        return 0;
    }
}