import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import javax.security.auth.x500.X500Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import javax.security.auth.x509.X509Certificate;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.subject.Subject;
import javax.security.auth.x50.X50Principal;

import sun.security.x509.X509Subject;

public class java_15849_CredentialValidator_A01 implements CredentialValidator {

    private KeyStore keystore;

    public java_15849_CredentialValidator_A01(KeyStore keystore) {
        this.keystore = keystore;
    }

    @Override
    public Collection<? extends Principal> validate(Subject subject, CallbackHandler callbackHandler) throws CredentialNotFoundException, CredentialAwareException, InternalException {
        return Collections.emptyList();
    }

    @Override
    public boolean validate(Subject subject, Object credentials, Collection<? extends Principal> identityHints, CallbackHandler callbackHandler) throws CredentialNotFoundException, CredentialAwareException, InternalException {
        return false;
    }

    @Override
    public boolean validate(Subject subject, Object credentials, Collection<? extends Principal> identityHints) throws CredentialAwareException, InternalException {
        return false;
    }

    @Override
    public boolean validate(Subject subject, Object credentials) throws CredentialAwareException, InternalException {
        return false;
    }

    @Override
    public boolean validate(Subject subject) throws CredentialAwareException, InternalException {
        return false;
    }

    @Override
    public boolean validate(Object credentials) throws CredentialAwareException, InternalException {
        return false;
    }

    @Override
    public boolean validate(Subject subject, String callerQualifiedName, String action, String identifier, Object credentials) throws CredentialAwareException, InternalException {
        return false;
    }

    @Override
    public boolean validate(Subject subject, String callerQualifiedName, String action, String identifier, Object credentials, String[] attrs) throws CredentialAwareException, InternalException {
        return false;
    }
}