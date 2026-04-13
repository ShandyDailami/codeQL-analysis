import java.io.IOException;
import java.net.InetSocketAddr;
import java.security.KeyStore;
import java.security.cert.Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_03889_SocketServer_A07 {

    private static final String KEY_STORE = "server.jks";
    private static final String KEY_STORE_PASSWORD = "password";
    private static final String TRUST_STORE = "client.jks";
    private static final String TRUST_STORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(getKeyStore(KEY_STORE, KEY_STORE_PASSWORD),
                getKeyStorePassword(KEY_STORE_PASSWORD),
                new TrustManagerFactory().getDefaultTrustManager(getTrustStore(TRUST_STORE, TRUST_STORE_PASSWORD)),
                getKeyPassword(KEY_STORE_PASSWORD);
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        serverSocket.setReuseAddress(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setReuseAddress(true);
            handleClient(clientSocket);
        }
    }

    private static void handleClient(SSLSocket clientSocket) {
        // Handle client connection here
    }

    private static KeyStore getKeyStore(String keyStorePath, String keyStorePassword) throws Exception {
        return KeyStore.getInstance("JKS");
    }

    private static String getKeyStorePassword(String password) throws Exception {
        return password;
    }

    private static KeyStore getTrustStore(String trustStorePath, String trustStorePassword) throws Exception {
        return KeyStore.getInstance("JKS");
    }

    private static String getTrustStorePassword(String password) throws Exception {
        return password;
    }

    private static String getKeyPassword(String password) throws Exception {
        return password;
    }
}