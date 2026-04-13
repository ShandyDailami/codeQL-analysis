import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_22510_SocketServer_A03 {
    private static final String KEYSTORE_FILENAME = "mykeystore.jks";
    private static final String KEYSTORE_PASSWORD = "mypassword";
    private static final String KEY_ALIAS = "mykey";

    public static void main(String[] args) throws KeyStoreException, IOException,
            CertificateException, UnsupportedCertificateException {
        char[] password = KEYSTORE_PASSWORD.toCharArray();

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream(KEYSTORE_FILENAME), password);

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) tmf.getTrustManagerFactory().getTrustManagers()[0];

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444);
        sslServerSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();
            System.out.println("Client connected: " + sslSocket.getRemoteSocketAddress());

            // You can add here your custom authentication mechanism

            sslSocket.close();
        }
    }
}