import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

import sun.security.x509.X509Subject;

public class java_14589_CredentialValidator_A08 implements CallbackHandler {

    @Override
    public java.security.Authentication getAuthentication(Subject subject) {
        return null;
    }

    @Override
    public java.security.Authentication getOneWayAuthentication(Subject subject, Object details) {
        return null;
    }

    @Override
    public void finish(Subject subject, Object details) {
        // no-op
    }

    @Override
    public Subject authenticate(Subject subject, Object details, CallbackHandler callbackHandler, Object additionalInfo) throws LoginException, CertificateException {
        return null;
    }

    @Override
    public Subject authenticate(Subject subject, Object details) throws LoginException, CertificateException {
        return null;
    }

    @Override
    public Subject authenticate(CallbackHandler callbackHandler, Object additionalInfo) throws LoginException, CertificateException {
        return null;
    }

    @Override
    public Subject authenticate(CallbackHandler callbackHandler) throws LoginException, CertificateException {
        return null;
    }

    @Override
    public Subject authenticate(Object additionalInfo) throws LoginException, CertificateException {
        return null;
    }
}

public class CustomCertificateValidator implements javax.security.auth.login.LoginModule.CertificateValidator {

    @Override
    public void validate(X509Certificate cert) throws CertificateException {
        // No-op, just need to meet the interface requirements
    }

    @Override
    public X509Certificate[] getCertificateChain(String authRequest) throws CertificateException {
        // No-op, just need to meet the interface requirements
        return null;
    }

    @Override
    public String getPasswordAuthenticationRequest(String arg0) throws LoginException, CertificateException {
        // No-op, just need to meet the interface requirements
        return null;
    }
}