import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManagerFactory;

public class java_15552_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SecureServer.class.getName());
    private static final String SSL_PORT = "1234";
    private static final String KEY_STORE = "path_to_your_keystore";
    private static final String KEY_STORE_PASSWORD = "password_for_keystore";
    private static final String KEY_ALIAS = "key_alias";
    private static final String KEY_PASSWORD = "password_for_key";

    public static void main(String[] args) {
        SSLServerSocket sslServerSocket = null;
        try {
            KeyManagerFactory kmf = KeyManagerFactory.getDefaultInstance(
                    KeyStoreUtils.createKeyStore(KEY_STORE, KEY_STORE_PASSWORD, KEY_ALIAS, KEY_PASSWORD),
                    KEY_PASSWORD);

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) sslServerSocket.getSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
            sslServerSocket.setNeedClientAuth(true);

            SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            clientSocket.startHandshake();

            logger.log(Level.INFO, "Client {0} successfully authenticated and handshake completed", clientSocket.getRemoteSocketAddress());

            InputStream clientInput = clientSocket.getInputStream();

            // Process input stream...

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception caught", ex);
        } finally {
            if (sslServerSocket != null) {
                try {
                    sslServerSocket.close();
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, "Failed to close the server socket", ex);
                }
            }
        }
    }
}