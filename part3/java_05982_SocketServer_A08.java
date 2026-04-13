import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.ServerSocket;
import javax.net.ssl.SSLSocket;

public class java_05982_SocketServer_A08 {

    private static final String KEYSTORE_LOCATION = "src/main/resources/client.keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "alias";

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverChannel.socket();

        // Load the keystore
        KeyStore keystore = KeyStore.getInstance("JKS");
        char[] keystorePassword = KEYSTORE_PASSWORD.toCharArray();
        keystore.load(getClass().getResourceAsStream("/client.keystore"), keystorePassword);

        // Load the key manager factory
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keystore, keystorePassword);

        // Set up the server socket
        serverSocket.bind(new InetSocketAddress(8443));
        serverSocket.setNeedClient(true);

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            Key key = keyManagerFactory.getKey(KEY_ALIAS);

            SSLSocket sslSocket = (SSLSocket) clientChannel.accept();
            sslSocket.setNeedClient(true);
            sslSocket.setUseClientMode(true);
            sslSocket.setKeyPair(key);
            sslSocket.setEnabledCipherSuites(sslSocket.getSupportedCipherSuites());

            // Handshake
            sslSocket.handshake();

            // Receive the certificate
            Certificate certificate = sslSocket.getSession().getPeerCertificate();
            // Now you can use the certificate for your security sensitive operations
        }
    }
}