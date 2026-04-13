import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.x50.X50Principal;

import sun.security.util.SecurityUtils;

public class java_32282_CredentialValidator_A07 {

    public X509Certificate[] validate(X509Certificate[] chain, String authType) throws CertificateException {
        X509Certificate cert = chain[0];

        // Print the certificate subject name
        System.out.println(new X500Principal(cert.getSubjectX500Principal()).getName());

        // Check if it is a wildcard certificate (used for authentication requests)
        if (cert.getSubjectDN().equals("CN=*.example.com")) {
            System.out.println("Wildcard Certificate: Authentication request");
        } else {
            System.out.println("Regular Certificate: Authentication response");
        }

        // Check if the certificate is expired
        if (cert.getNotAfter().before(new java.util.Date())) {
            System.out.println("Certificate is expired");
            // Return null so that the server knows not to use the certificate
            return null;
        }

        return chain;
    }

    public X509Certificate[] validate(X509Certificate[] chain, String authType, X50Principal[] authenticated, String id) throws CertificateException {
        return validate(chain, authType);
    }

    public X509Certificate[] validate(X509Certificate[] chain, String authType, X50Principal[] authenticated) throws CertificateException {
        return validate(chain, authType, authenticated, null);
    }

}