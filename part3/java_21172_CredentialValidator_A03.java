import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.security.auth.x500.X500Principal;

public class java_21172_CredentialValidator_A03 {

    // Creating a custom SSL socket factory to get certificate information
    SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLContext.getDefault().getSocketFactory();

    // Method to validate the certificate
    public void validateCertificate(String hostname) throws Exception {
        SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket(hostname, 443);
        socket.setHostname(hostname);

        // Getting the certificate from the server
        X509Certificate certificate = (X509Certificate) socket.getSession().getPeerCertificate();

        // Decoding the subject alternative name from the certificate
        X500Principal subjectAltName = certificate.getSubjectX500Principal();
        System.out.println("Subject Alternative Name (SAN): " + subjectAltName.getName());

        // Decoding the subject name from the certificate
        X500Principal subject = certificate.getSubjectX500Principal();
        System.out.println("Subject Name: " + subject.getName());

        // Decoding the issuer name from the certificate
        X500Principal issuer = certificate.getIssuerX500Principal();
        System.out.println("Issuer Name: " + issuer.getName());

        // Decoding the serial number from the certificate
        System.out.println("Serial Number: " + Base64.getEncoder().encodeToString(certificate.getSerialNumber().toString().getBytes()));

        socket.close();
    }
}