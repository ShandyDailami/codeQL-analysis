import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_06281_CredentialValidator_A08 {

    public boolean validateCertificate(String serverUrl, SSLSocketFactory sslSocketFactory, X509Certificate cert) {
        try {
            SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket(serverUrl, 443);
            socket.setEnabled(true);
            socket.setSSLSocketFactory(sslSocketFactory);
            socket.getSession().setDefaultCertificate(cert);

            // Check if certificate is valid against trusted CAs
            X509Certificate[] chain = socket.getSession().getChain(serverUrl);
            if (chain == null || chain.length == 0) {
                System.out.println("No certificate chain returned from server");
                return false;
            }

            // Check if certificate is valid
            X509Certificate peerCert = chain[0];
            if (!peerCert.equals(cert)) {
                System.out.println("Peer certificate does not match with expected certificate");
                return false;
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLContext.getDefault().getSocketFactory();

            // Generate a self-signed certificate
            X509Certificate cert = (X509Certificate) CertificateStore.getInstance().getCertificate("self-signed");

            // Validate certificate
            if (new CredentialValidator().validateCertificate("www.google.com", sslSocketFactory, cert)) {
                System.out.println("Certificate is valid");
            } else {
                System.out.println("Certificate is not valid");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}