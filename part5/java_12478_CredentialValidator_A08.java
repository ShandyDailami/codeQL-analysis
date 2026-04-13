import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.cert.CertificateException;
import java.util.Arrays;

public class java_12478_CredentialValidator_A08 {

    public static boolean validateCertificate(X509Certificate certificate) {
        if (certificate == null) {
            throw new IllegalArgumentException("Certificate cannot be null");
        }

        try {
            validateIssuerAndSignature(certificate);
            validateSubject(certificate);
            validateNotAfter(certificate);
            validateNotBefore(certificate);
            validateExtensions(certificate);

            return true;
        } catch (CertificateException e) {
            System.out.println("Invalid certificate: " + e.getMessage());
            return false;
        }
    }

    private static void validateIssuerAndSignature(X509Certificate certificate) throws CertificateException {
        System.out.println("Validating issuer and signature...");
        String issuer = certificate.getIssuerDN().toString();
        String signatureAlgorithm = certificate.getSigAlgName();

        if (!issuer.equals("CN=MyCompany, OU=MyDepartment, O=MyOrganization, C=US")) {
            throw new CertificateException("Invalid issuer: " + issuer);
        }

        if (!Arrays.equals(certificate.getSignatureAlgName(), signatureAlgorithm.getBytes())) {
            throw new CertificateException("Invalid signature algorithm: " + signatureAlgorithm);
        }
    }

    private static void validateSubject(X509Certificate certificate) throws CertificateException {
        System.out.println("Validating subject...");
        String subject = certificate.getSubjectDN().toString();

        if (!subject.equals("CN=MyUser, OU=MyDepartment, O=MyOrganization, C=US")) {
            throw new CertificateException("Invalid subject: " + subject);
        }
    }

    private static void validateNotAfter(X509Certificate certificate) throws CertificateException {
        System.out.println("Validating not after...");
        long notAfter = certificate.getNotAfter().getTime();
        long now = System.currentTimeMillis();

        if (notAfter < now) {
            throw new CertificateException("Invalid notAfter date: " + notAfter);
        }
    }

    private static void validateNotBefore(X509Certificate certificate) throws CertificateException {
        System.out.println("Validating not before...");
        long notBefore = certificate.getNotBefore().getTime();
        long now = System.currentTimeMillis();

        if (notBefore > now) {
            throw new CertificateException("Invalid notBefore date: " + notBefore);
        }
    }

    private static void validateExtensions(X509Certificate certificate) throws CertificateException {
        System.out.println("Validating extensions...");
        X509Extension[] extensions = certificate.getExtensions();

        if (extensions.length != 1) {
            throw new CertificateException("Invalid number of extensions: " + extensions.length);
        }

        String extensionOID = extensions[0].getOid().toString();

        if (!extensionOID.equals("2.5.29.17=")) {
            throw new CertificateException("Invalid extension OID: " + extensionOID);
        }
    }
}