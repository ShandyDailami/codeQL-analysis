import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_19331_SocketServer_A08 {

    private static final String SSL_PORT = "8443";
    private static final String KEYSTORE_LOCATION = "/path/to/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "alias";

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
        SSLContext sslContext = getSSLContext(KEYSTORE_LOCATION, KEYSTORE_PASSWORD, KEY_ALIAS);
        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(Integer.parseInt(SSL_PORT));
        serverSocket.setReuseAddress(true);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            SSLSocket sslSocket = (SSLSocket) socket.createSocket(socket.getInetAddress(), socket.getPort(), InetAddress.getLocalHost(), 443);
            sslSocket.setUseClientMode(true);
            sslSocket.setNeedClientAuth(true);

            // Setup the KeyManager for SSL
            KeyManager[] keyManagers = getKeyManager(KEYSTORE_LOCATION, KEYSTORE_PASSWORD);
            sslSocket.setKeyManagers(keyManagers);

            // Setup the TrustManager for SSL
            sslSocket.setTrustManager(getTrustManager());

            // Setup the SSLContext for SSL
            sslSocket.setSSLContext(sslContext);

            // Start handling the SSL socket
            new Handler(sslSocket).start();
        }
    }

    private static SSLContext getSSLContext(String keystoreLocation, String keystorePassword, String alias) throws KeyStoreException, IOException, NoSuchAlgorithmException, KeyManagementException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream(keystoreLocation), keystorePassword.toCharArray());

        KeyManager[] keyManagers = new KeyManager[]{new KeyManager[]{new JKSKeyManager(keyStore, keystorePassword.toCharArray(), alias)}};

        TrustManager[] trustManagers = new TrustManager[]{new TrustManager[]{new X509TrustManager()}};

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(keyManagers, trustManagers, null);
        return sslContext;
    }

    private static KeyManager[] getKeyManager(String keystoreLocation, String keystorePassword) throws IOException, KeyStoreException, NoSuchAlgorithmException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream(keystoreLocation), keystorePassword.toCharArray());

        KeyManager[] keyManagers = new KeyManager[]{new JKSKeyManager(keyStore, keystorePassword.toCharArray())};
        return keyManagers;
    }

    private static TrustManager getTrustManager() {
        return new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
    }
}