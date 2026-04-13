import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class java_40593_SocketServer_A08 {

    private static final String SSL_KEY_STORE = "sslkeystore.jks";
    private static final String SSL_KEY_STORE_PASSWORD = "mypassword";
    private static final String SSL_TRUST_STORE = "sstruststore.jks";
    private static final String SSL_TRUST_STORE_PASSWORD = "mypassword";
    private static final String SSL_KEY_ALIAS = "sslkey";

    public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, IOException, KeyManagementException {
        SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory();
        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(5000);
        serverSocket.setReuseAddress(true);

        System.out.println("Secure Socket Server started at " + serverSocket.getLocalSocketAddress());

        Socket socket = serverSocket.accept();
        System.out.println("Client connected at: " + socket.getRemoteSocketAddress());

        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(serverSocket.getLocalPort());
        sslServerSocket.setNeedClientAuth(true);

        TrustManagerFactory trustManagerFactory = getTrustManagerFactory();
        SSLContext sslContext = (SSLContext) SSLContext.getInstance("SSL");
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

        sslServerSocket.setSSLServerSocket(sslServerSocket);
        sslServerSocket.setNeedClientAuth(true);

        // rest of the code...
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory() throws KeyStoreException, NoSuchAlgorithmException, IOException {
        return (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
    }

    private static TrustManagerFactory getTrustManagerFactory() throws KeyStoreException, NoSuchAlgorithmException, IOException, KeyManagementException {
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(InetAddress.getClass().getResourceAsStream("/sstruststore.jks"), SSL_TRUST_STORE_PASSWORD.toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        return trustManagerFactory;
    }
}