import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.SSLSocket;

public class java_23696_SocketServer_A03 {
    private static final String KEYSTORE = "mykeystore";
    private static final String KEYSTORE_PASSWORD = "mypassword";
    private static final String TRUSTSTORE = "mytruststore";
    private static final String TRUSTSTORE_PASSWORD = "mypassword";
    private static final String ALGORITHM = "SunJSSE";

    public static void main(String[] args) throws KeyStoreException, CertificateException, IOException {
        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE), KEYSTORE_PASSWORD.toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(ALGORITHM);
        tmf.init(keystore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keystore, KEYSTORE_PASSWORD.toCharArray(), new java.security.cert.Certificate[] {}, tmf);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) sslContext.getServerSocketFactory();
        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSocket(socket, socket.getInetAddress(), serverSocket.getLocalPort(), true);
            sslSocket.setNeedClientAuthentication(true);
            sslSocket.startHandshake();
            System.out.println("Client " + sslSocket.getRemoteSocketAddress() + " connected");
        }
    }
}