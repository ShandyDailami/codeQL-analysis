import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServlet;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_25330_SocketServer_A08 {

    private static final String KEYSTORE_LOCATION = "/path/to/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "keystorePassword";
    private static final String TRUSTSTORE_LOCATION = "/path/to/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "truststorePassword";

    public static void main(String[] args) throws KeyManagementException, CertificateException, IOException {
        SSLContext sslContext = getSSLContext(KEYSTORE_LOCATION, KEYSTORE_PASSWORD, TRUSTSTORE_LOCATION, TRUSTSTORE_PASSWORD);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8443);
            while (true) {
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                SSLServlet servlet = new SSLServlet(sslContext);
                servlet.service(socket, new Request(), new Response());
                socket.close();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static SSLContext getSSLContext(String keyStorePath, String keyStorePassword, String trustStorePath, String trustStorePassword) throws KeyManagementException, CertificateException, IOException {
        SSLContext sslContext = null;
        KeyManagerFactory keyManagerFactory = getKeyManagerFactory(keyStorePath, keyStorePassword);
        TrustManagerFactory trustManagerFactory = getTrustManagerFactory(trustStorePath, trustStorePassword);

        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);

        return sslContext;
    }

    private static KeyManagerFactory getKeyManagerFactory(String keyStorePath, String keyStorePassword) throws KeyStoreException, NoSuchAlgorithmException, IOException {
        KeyStore keystore = KeyStore.getInstance("JKS");
        InputStream keystoreInputStream = SocketServer.class.getResourceAsStream(keyStorePath);
        keystore.load(keystoreInputStream, keyStorePassword.toCharArray());

        return new KeyManagerFactory.Builder(keystore, keyStorePassword.toCharArray(), new SecureRandom()).build();
    }

    private static TrustManagerFactory getTrustManagerFactory(String trustStorePath, String trustStorePassword) throws TrustStoreException, IOException, KeyStoreException, NoSuchAlgorithmException {
        KeyStore trustStore = KeyStore.getInstance("JKS");
        InputStream trustStoreInputStream = SocketServer.class.getResourceAsStream(trustStorePath);
        trustStore.load(trustStoreInputStream, trustStorePassword.toCharArray());

        return new TrustManagerFactory.Builder(trustStore, trustStorePassword.toCharArray(), new SecureRandom()).build();
    }
}