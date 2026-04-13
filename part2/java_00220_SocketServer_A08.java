import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_00220_SocketServer_A08 {

    private static final String KEY_STORE = "client.keystore";
    private static final char[] KEY_STORE_PASSWORD = "mypassword".toCharArray();
    private static final char[] PASSWORD = "mypassword".toCharArray();
    private static final String ALGORITHM = "SunRSADevice";

    public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, IOException, KeyManagementException {
        KeyManager[] keyManagers = getKeyManagers();
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(getKeyStore());
        sslServerSocketFactory.setKeyStorePassword(KEY_STORE_PASSWORD);
        sslServerSocketFactory.setKeyManagement(true);
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSSLSocket(socket);
            sslSocket.setNeedClientAuth(true);
            sslSocket.startHandshake();
            // Here you can add your own logic, like reading messages, etc.
        }
    }

    private static KeyStore getKeyStore() throws KeyStoreException, NoSuchAlgorithmException, IOException {
        return KeyStore.getInstance("JKS");
    }

    private static KeyManager[] getKeyManagers() throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        return new KeyManager[] { new KeyManagerImpl(PASSWORD, KEY_STORE, ALGORITHM, KEY_STORE_PASSWORD) };
    }

}