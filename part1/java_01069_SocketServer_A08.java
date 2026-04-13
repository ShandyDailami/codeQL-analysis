import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

public class java_01069_SocketServer_A08 {

    private static final String KEYSTORE = "path_to_your_keystore";
    private static final String KEYPASSWORD = "password";
    private static final String TRUSTSTORE = "path_to_your_truststore";
    private static final String TRUSTPASSWORD = "password";

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            KeyManagerFactory kmf = getKeyManagerFactory();
            sslServerSocket = (SSLServerSocket) kmf.getServerSocket(new ServerSocket(4444));

            while (true) {
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Client Connected");
                // Start handling the client here
            }
        } finally {
            sslServerSocket.close();
        }
    }

    private static KeyManagerFactory getKeyManagerFactory() throws IOException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE), KEYPASSWORD.toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.initKeyStore(keyStore, KEYPASSWORD.toCharArray());
        return keyManagerFactory;
    }
}