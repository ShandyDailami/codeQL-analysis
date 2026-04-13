import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class java_23211_SocketServer_A03 {
    private static final String KEYSTORE_LOCATION = "path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_LOCATION = "path/to/your/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLContext sslContext = createSSLContext();

        ServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) sslContext.getServerSocket(8443);
            while (true) {
                Socket socket = serverSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.createChannel();
                sslSocket.setNeedClientAuth(true);
                sslSocket.startHandshake();
                sslSocket.getSession().setExtraInfo(sslSocket.getCipherSuite());
                System.out.println("Client connected : " + sslSocket.getRemoteSocketAddress());
                // Here you can use sslSocket for communication with the client
            }
        } finally {
            serverSocket.close();
        }
    }

    private static SSLContext createSSLContext() throws Exception {
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(new java.security.KeyStoreStream(KEYSTORE_LOCATION, KEYSTORE_PASSWORD));

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);

        return sslContext;
    }
}