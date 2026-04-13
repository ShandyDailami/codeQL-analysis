import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManager;

public class java_39375_SocketServer_A07 {

    private static final String KEY_STORE_TYPE = "JKS";
    private static final String KEY_STORE = "server.jks";
    private static final String KEY_PASSWORD = "password";
    private static final String TRUST_STORE = "client.jks";
    private static final String TRUST_STORE_PASSWORD = "password";
    private static final String ALIAS = "socketServer";

    public static void main(String[] args) throws IOException, CertificateException {
        KeyManager[] keyManagers = getKeyManagers();
        SSLContext sslContext = getSslContext(keyManagers);

        ServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) sslContext.getServerSocket(8080);
            while (true) {
                SSLSocket client = (SSLSocket) serverSocket.accept();
                OutputStream out = client.getOutputStream();
                String response = "Hello World!";
                out.write(response.getBytes());
                client.close();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static SSLContext getSslContext(KeyManager[] keyManagers) throws IOException, CertificateException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers, null, null);
        return sslContext;
    }

    private static KeyManager[] getKeyManagers() throws IOException, CertificateException {
        KeyStore clientKeystore = KeyStore.getInstance(KEY_STORE_TYPE);
        clientKeystore.load(getClass().getResourceAsStream(KEY_STORE), KEY_PASSWORD.toCharArray());

        KeyStore trustStore = KeyStore.getInstance(KEY_STORE_TYPE);
        trustStore.load(getClass().getResourceAsStream(TRUST_STORE), TRUST_STORE_PASSWORD.toCharArray());

        KeyManager[] keyManagers = new KeyManager[]{new X509KeyManager()};
        TrustManager[] trustManagers = new TrustManager[]{new X509TrustManager()};

        return keyManagers;
    }
}