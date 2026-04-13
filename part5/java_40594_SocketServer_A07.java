import java.io.IOException;
import java.net.InetSocketAddr;
import java.net.StandardSocketOptions;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.CertificateManager;

public class java_40594_SocketServer_A07 {

    private static final String KEYSTORE_FILE = "server.keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_FILE = "client.truststore";
    private static final String TRUSTSTORE_PASSWORD = "password";
    private static final String KEY_MANAGER_ALGORITHM = KeyManagerFactory.getDefaultAlgorithm();
    private static final String CERTIFICATE_MANAGER_ALGORITHM = CertificateManager.getDefaultAlgorithm();

    public static void main(String[] args) throws Exception {
        SSLContext sslContext = createSslContext(KEYSTORE_FILE, KEYSTORE_PASSWORD, TRUSTSTORE_FILE, TRUSTSTORE_PASSWORD);
        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(new InetSocketAddr(8443));
        serverSocket.setSoOption(StandardSocketOptions.SO_REUSEADDR, true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setSoOption(StandardSocketOptions.SO_REUSEADDR, true);
            processRequest(clientSocket);
            clientSocket.close();
        }
    }

    private static void processRequest(SSLSocket clientSocket) {
        // Implement your request processing logic here
    }

    private static SSLContext createSslContext(String keystoreFile, String keystorePassword, String truststoreFile, String truststorePassword) throws IOException {
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_FILE, KEYSTORE_PASSWORD);
        keyStore.load(getClass().getResourceAsStream(KEYSTORE_FILE), keystorePassword.toCharArray());

        CertificateManager certificateManager = new CertificateManager(getClass().getResourceAsStream(truststoreFile), truststorePassword, truststorePassword);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KEY_MANAGER_ALGORITHM, certificateManager);
        keyManagerFactory.init(keyStore, keystorePassword.toCharArray());

        SSLContext sslContext = SSLContext.getInstance(CERTIFICATE_MANAGER_ALGORITHM);
        sslContext.init(keyManagerFactory.getKeyManagers(), certificateManager.getCertificateManagers(), null);

        return sslContext;
    }
}