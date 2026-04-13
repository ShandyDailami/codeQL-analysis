import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.PasswordAuthentication;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_33173_SocketServer_A03 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_ALIAS = "your_key_alias";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            serverSocket.setNeedClient(true);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Failed to create server socket.", ex);
            System.exit(-1);
        }

        SSLContext sslContext = setupSslContext(KEYSTORE_LOCATION, KEYSTORE_PASSWORD,
                TRUSTSTORE_LOCATION, TRUSTSTORE_PASSWORD, KEY_ALIAS);

        while (true) {
            try {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                logger.info("Accepted connection from " + clientSocket.getRemoteSocketAddress());

                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();

                // Here goes the business logic

                clientSocket.close();

            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Failed to handle client socket.", ex);
            }
        }
    }

    private static SSLContext setupSslContext(String keystoreLocation,
                                               String keystorePassword,
                                               String truststoreLocation,
                                               String truststorePassword,
                                               String keyAlias) {

        try {
            KeyManagerFactory keyManagerFactory = getKeyManagerFactory(keystoreLocation,
                    keystorePassword);
            CertificateManager certificateManager = new CertificateManager(truststoreLocation,
                    truststorePassword);

            return SSLContext.getInstance("SSL");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to setup SSLContext.", ex);
            System.exit(-1);
        }

        return null;
    }

    private static KeyManagerFactory getKeyManagerFactory(String keystoreLocation,
                                                        String keystorePassword) {
        try {
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKSAPI");
            keyManagerFactory.init(
                    new KeyStoreInputStream(keystoreLocation, keystorePassword.toCharArray()),
                    keystorePassword.toCharArray());

            return keyManagerFactory;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to get KeyManagerFactory.", ex);
            System.exit(-1);
        }

        return null;
    }
}