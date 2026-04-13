import java.io.IOException;
import java.net.InetSocketAddr;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;

public class java_21435_SocketServer_A08 {

    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "password";
    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE = "truststore";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException, IOException {
        TrustManager[] trustAllCerts = new TrustManager[]{new TrustAllManager()};
        KeyManager[] keyManagers = getKeyManagers();

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(keyManagers, trustAllCerts, null);

        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(8090);
        serverSocket.setReuseAddress(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setReuseAddress(true);

            byte[] len = new byte[1024];
            int read = clientSocket.getInputStream().read(len, 0, len.length);
            if (read < 0) {
                break;
            }

            byte[] out = new byte[read];
            System.arraycopy(len, 0, out, 0, read);
            System.out.println("Received: " + new String(out));

            clientSocket.getOutputStream().write(out, 0, read);
            clientSocket.getOutputStream().flush();
        }

        serverSocket.close();
    }

    private static KeyManager[] getKeyManagers() throws KeyStoreException, NoSuchAlgorithmException, IOException {
        char[] password = "password".toCharArray();

        KeyStore clientKeystore = KeyStore.getInstance(KeyStore.getDefaultType());
        clientKeystore.load(getClass().getResourceAsStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD);

        KeyStore serverKeystore = KeyStore.getInstance(KeyStore.getDefaultType());
        serverKeystore.load(getClass().getResourceAsStream(SERVER_KEYSTORE), SERVER_KEYSTORE_PASSWORD);

        KeyManager[] keyManagers = new KeyManager[]{new KeyManagerSSL(serverKeystore, password, "SSL")};
        return keyManagers;
    }

    private static class TrustAllManager implements TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[]{};
        }

        public boolean checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType) {
            return true;
        }

        public boolean checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType) {
            return true;
        }
    }
}