import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509Credential;
import javax.security.auth.Credential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

import sun.security.x509.X509CertImpl;
import sun.security.x509.X500PrincipalImpl;
import sun.security.x50.X50Principal;

public class java_05403_CredentialValidator_A03 implements CredentialValidator {
    public CredentialValidationResult validate(Credential credential) throws LoginException {
        if (credential instanceof X509Credential) {
            X509Credential x509Credential = (X509Credential) credential;
            X509Certificate certificate = x509Credential.getCertificate();
            PrivateKey privateKey = certificate.getPrivateKey();

            System.out.println("Private key: " + privateKey);
            System.out.println("Certificate: " + certificate);

            return new CredentialValidationResult("Success", "");
        } else {
            return new CredentialValidationResult("Failure", "Invalid credential type");
        }
    }

    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            public CredentialValidationResult handle(Callback[] callbacks) throws UnsupportedCallbackException {
                return validate(callbacks[0].getRequest().getCredentials());
            }
        };
    }
}