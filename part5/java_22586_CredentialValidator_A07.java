import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.login.CredentialException;
import javax.security.auth.x500.X500Principal;
import javax.security.auth.x509.X509CertStore;

import sun.security.x509.X509Store;

public class java_22586_CredentialValidator_A07 {

    private X509Store store;

    public java_22586_CredentialValidator_A07() throws CredentialException {
        store = new X509Store(X509Store.getInstance("X509"), null);
        store.load(null);
    }

    public void validate(X509Certificate cert, X500Principal credential) throws CredentialException, CertificateException {
        store.addCertificate(cert);

        // Validate the certificate with the X509CertStore
        store.setDefaultCertificate(cert);
        X509CertStore newStore = new X509CertStore(store, credential.getSID());
        newStore.setDefaultCertificate(cert);

        // If there is a successful validation, renew the store
        if (newStore.validCertificateCount() > 0) {
            store = newStore;
        } else {
            throw new CredentialException("Validation failed.");
        }
    }
}