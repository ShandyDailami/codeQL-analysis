import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;

public class java_02371_SocketServer_A03 {
    private static final String KEYSTORE = "server.jks";
    private static final char[] KEYSTORE_PASSWORD = "password".toCharArray();
    private static final String TRUSTSTORE = "client.jks";
    private static final char[] TRUSTSTORE_PASSWORD = "password".toCharArray();
    private static final String ALGORITHM = "SunJSSE";

    public static void main(String[] args) throws Exception {
        SSLContext sslContext = createSSLContext(KEYSTORE, KEYSTORE_PASSWORD, TRUSTSTORE, TRUSTSTORE_PASSWORD);

        ServerSocket server = (ServerSocket) sslContext.getServerSocket(8443);
        server.setReuseAddress(true);

        while (true) {
            Socket socket = server.accept();
            SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);
            handle(sslSocket);
        }
    }

    private static void handle(SSLSocket socket) {
        // handle the socket
    }

    private static SSLContext createSSLContext(String keyStorePath, char[] keyStorePassword,
                                               String trustStorePath, char[] trustStorePassword) throws Exception {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunJSSE");
        KeyStore keyStore = KeyStore.getInstance("JKS");
        Certificate certificate = null;

        keyStore.load(getClass().getResourceAsStream(keyStorePath), keyStorePassword);
        keyManagerFactory.init(keyStore, keyStorePassword);

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(getClass().getResourceAsStream(trustStorePath), trustStorePassword);

        SSLContext sslContext = SSLContext.getInstance(ALGORITHM);
        sslContext.init(keyManagerFactory, trustStore, null);

        return sslContext;
    }
}