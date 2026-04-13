import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

public class java_28189_SocketServer_A07 {

    private static final String SSL_PORT = "8443";
    private static final String KEY_STORE = "path_to_your_keystore";
    private static final String KEY_STORE_PASSWORD = "password_for_keystore";
    private static final String TRUST_STORE = "path_to_your_truststore";
    private static final String TRUST_STORE_PASSWORD = "password_for_truststore";

    public static void main(String[] args) throws IOException, CertificateException, KeyStoreException {
        ServerSocket server = null;
        SSLServerSocket sslServer = null;

        KeyManager[] keyManagers = getKeyManagers();
        TrustManager[] trustManagers = getTrustManagers();

        sslServer = (SSLServerSocket) server.createServerSocket(Integer.parseInt(SSL_PORT));
        sslServer.setNeedClientAuth(true);

        sslServer.setKeyManagers(keyManagers);
        sslServer.setTrustManagers(trustManagers);

        SSLSocket socket = (SSLSocket) sslServer.accept();
        socket.startHandshake();

        // Here you can handle the socket connection after the handshake

        socket.close();
    }

    private static KeyManager[] getKeyManagers() throws KeyStoreException, IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream(KEY_STORE), KEY_STORE_PASSWORD.toCharArray());

        return new KeyManager[] { new KeyStoreKeyManager(keyStore, KEY_STORE_PASSWORD.toCharArray()) };
    }

    private static TrustManager[] getTrustManagers() throws KeyStoreException, IOException, CertificateException {
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(getClass().getResourceAsStream(TRUST_STORE), TRUST_STORE_PASSWORD.toCharArray());

        return new TrustManager[] { new TrustManagerKeyStore(trustStore, TRUST_STORE_PASSWORD.toCharArray()) };
    }
}