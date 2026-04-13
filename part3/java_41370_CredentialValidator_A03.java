import java.security.cert.Certificate;
import java.util.Base64;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class java_41370_CredentialValidator_A03 {
    public static void main(String[] args) throws Exception {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("google.com", 443);
        sslSocket.startHandshake();
        sslSocket.getSession().setProtocolVersion(TLSv1_2_CLIENT_HELLO);
        sslSocket.setEnabledProtocols(new String[] { SSLConstants.TLSv1_2 });
        Certificate[] certificates = sslSocket.getSession().getPeerCertificates();
        System.out.println("Certificate: " + new String(Base64.getEncoder().encode(certificates[0].getEncoded())));
        sslSocket.close();
    }
}