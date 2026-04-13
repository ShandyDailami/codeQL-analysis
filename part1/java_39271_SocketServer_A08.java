import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.security.KeyStore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_39271_SocketServer_A08 {
    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());

    private static final String KEYSTORE_PATH = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_PATH = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "password";
    private static final String ALIAS = "socketServer";

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());

            serverSocket = (SSLServerSocket) new SSLServerSocket(8443, InetAddress.getByName("localhost"), keystore, TRUSTSTORE_PASSWORD.toCharArray());
            serverSocket.setNeedClientAuth(true);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                clientSocket.startHandshake();
                LOGGER.log(Level.INFO, "Client accepted from {0}", clientSocket.getRemoteSocketAddress());

                // perform your tasks here
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error accepting client", ex);
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Error closing serverSocket", ex);
            }
        }
    }
}