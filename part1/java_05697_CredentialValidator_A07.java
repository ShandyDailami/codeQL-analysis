import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import sun.security.x509.X509CertImpl;
import sun.security.util.ObjectIdentifier;

public class java_05697_CredentialValidator_A07 implements sun.security.tools.keytool.CertValidator {

    private static List<X509Certificate> acceptedCerts;

    static {
        acceptedCerts = new ArrayList<>();
        acceptedCerts.add(createDummyCert("1.3.6.1.4.1.311.2.2.1.1.1", "Test Cert 1"));
        acceptedCerts.add(createDummyCert("1.3.6.1.4.1.311.2.2.1.1.2", "Test Cert 2"));
    }

    private static X509CertImpl createDummyCert(String oid, String commonName) {
        return new X509CertImpl(new ObjectIdentifier(oid), commonName,
                new ObjectIdentifier("1.3.6.1.2.1.111.7.4.1.1"), // issuer
                new ObjectIdentifier("1.3.6.1.2.1.111.7.4.1.1"), // subject
                null, // serial number
                new java.util.Date(), // not before
                new java.util.Date(), // not after
                new java.security.cert.Certificate[] {}); // no subjec t certs
    }

    @Override
    public List<X509Certificate> getAcceptedCerts() {
        return acceptedCerts;
    }

    @Override
    public List<ObjectIdentifier> getAcceptedIssuers() {
        return null;
    }

    @Override
    public ObjectIdentifier[] getAcceptedIssuerNames() {
        return null;
    }

    @Override
    public boolean isCertificateExpired(X509Certificate cert) {
        return false;
    }

    @Override
    public boolean isCertificateExpired(ObjectIdentifier issuer, java.util.Date expirationDate) {
        return false;
    }

    @Override
    public boolean isCertificateIssuedBy(X509Certificate cert, ObjectIdentifier issuer) {
        return false;
    }

    @Override
    public boolean isCertificateIssuedBy(ObjectIdentifier issuer, java.util.Date expirationDate) {
        return false;
    }

    @Override
    public boolean isCertificateValid(X509Certificate cert) {
        return false;
    }

    @Override
    public boolean isCertificateValid(ObjectIdentifier issuer, java.util.Date expirationDate) {
        return false;
    }

    @Override
    public boolean isCertificateValid(X509Certificate cert, ObjectIdentifier issuer,
            java.util.Date notBefore, java.util.Date notAfter) {
        return false;
    }

    @Override
    public boolean isCertificateValid(ObjectIdentifier issuer, java.util.Date notBefore,
            java.util.Date notAfter) {
        return false;
    }
}