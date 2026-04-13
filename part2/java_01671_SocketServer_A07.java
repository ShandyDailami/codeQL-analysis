import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_01671_SocketServer_A07 {
    private static final String KEYSTORE = "path/to/your/keystore";
    private static final String KEYSTORE_PASSWORD = "yourpassword";
    private static final String TRUSTSTORE = "path/to/your/truststore";
    private static final String TRUSTSTORE_PASSWORD = "yourpassword";

    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;

        KeyManagerFactory kmf = getKeyManagerFactory();
        TrustManagerFactory tmf = getTrustManagerFactory();

        SSLServerSocket sslsocket = (SSLServerSocket) socket.accept();
        SSLSocket sslSocket = (SSLSocket) sslsocket.accept();

        sslSocket.setSSLContext(getSSLContext(kmf, tmf));

        InetAddress ip = sslSocket.getInetAddress();
        System.out.println("Connected to " + ip.getHostAddress());

        socket.close();
    }

    private static SSLContext getSSLContext(KeyManagerFactory kmf, TrustManagerFactory tmf) throws Exception {
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new java.security.cert.CertificateInputStream(new java.io.FileInputStream(KEYSTORE)), KEYSTORE_PASSWORD.toCharArray());

        SSLContext sslcontext = SSLContext.getInstance("TLS");
        sslcontext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        return sslcontext;
    }

    private static KeyManagerFactory getKeyManagerFactory() throws Exception {
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new java.security.cert.CertificateInputStream(new java.io.FileInputStream(KEYSTORE)), KEYSTORE_PASSWORD.toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKS");
        kmf.init(ks, KEYSTORE_PASSWORD.toCharArray());

        return kmf;
    }

    private static TrustManagerFactory getTrustManagerFactory() throws Exception {
        TrustStore truststore = new TrustStore(TRUSTSTORE, TRUSTSTORE_PASSWORD);

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(truststore);

        return tmf;
    }
}