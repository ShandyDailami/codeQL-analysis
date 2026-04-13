import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.security.auth.x500.X500Principal;
import java.net.InetAddress;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.cert.Certificate;

public class java_31213_CredentialValidator_A03 {

    public boolean validate(String hostname, int port, String certSerialNumber, PrivateKey privateKey) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new PrivateKey[] { privateKey }, null);

        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(hostname, port);

        sslSocket.setSoTimeout(60000);

        sslSocket.connect();

        Certificate[] certificates = sslSocket.getSession().getPeerCertificateChain();

        for (Certificate certificate : certificates) {
            if (certificate instanceof X509Certificate) {
                X509Certificate x509Certificate = (X509Certificate) certificate;
                X500Principal subject = x509Certificate.getSubjectX500Principal();

                if (subject.toString().equals(certSerialNumber)) {
                    return true;
                }
            }
        }

        sslSocket.close();

        return false;
    }
}