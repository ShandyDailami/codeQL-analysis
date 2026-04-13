import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_04887_SocketServer_A08 {
    private static final String KEYSTORE_PATH = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password_of_your_keystore";
    private static final String TRUSTSTORE_PATH = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "password_of_your_truststore";
    private static final String KEY_ALIAS = "alias_for_your_key";

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = getSSLServerSocketFactory();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443);

        System.out.println("Server is listening on port 8443");

        while (true) {
            try {
                PrintWriter out = new PrintWriter(sslServerSocket.getOutputStream(), true);
                SSLServerSocket clientSocket = (SSLServerSocket) sslServerSocket.accept();

                System.out.println("Accepted new connection from " + clientSocket.getInetAddress().getHostAddress());

                out.println("Handshake completed successfully");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println("Server received: " + inputLine);
                }
            } catch (IOException e) {
                System.out.println("Failed to accept connection on port 8443");
                e.printStackTrace();
            }
        }
    }

    private static SSLServerSocketFactory getSSLServerSocketFactory() throws IOException {
        KeyManagerFactory kmf = getKeyManagerFactory();
        TrustManagerFactory tmf = getTrustManagerFactory();

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        sslServerSocketFactory.setKeyManagers(kmf.getKeyManagers());
        sslServerSocketFactory.setTrustManagers(tmf.getTrustManagers());

        return sslServerSocketFactory;
    }

    private static KeyManagerFactory getKeyManagerFactory() throws IOException {
        KeyStore clientKeystore = getKeyStore(KEYSTORE_PATH, KEYSTORE_PASSWORD);
        return getKeyManagerFactory(clientKeystore);
    }

    private static TrustManagerFactory getTrustManagerFactory() throws IOException {
        KeyStore truststore = getKeyStore(TRUSTSTORE_PATH, TRUSTSTORE_PASSWORD);
        return getTrustManagerFactory(truststore);
    }

    private static KeyStore getKeyStore(String path, String password) throws IOException {
        char[] passwordCharArray = password.toCharArray();
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream(path), passwordCharArray);
        return keyStore;
    }

    private static TrustStore getTrustStore(String path, String password) throws IOException {
        char[] passwordCharArray = password.toCharArray();
        TrustStore trustStore = (TrustStore) KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(new FileInputStream(path), passwordCharArray);
        return trustStore;
    }

    private static KeyManagerFactory getKeyManagerFactory(KeyStore clientKeystore) throws IOException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyFactory.getDefaultAlgorithm());
        keyManagerFactory.init(clientKeystore, KEYSTORE_PASSWORD.toCharArray());
        return keyManagerFactory;
    }

    private static TrustManagerFactory getTrustManagerFactory(TrustStore trustStore) throws IOException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);
        return trustManagerFactory;
    }
}