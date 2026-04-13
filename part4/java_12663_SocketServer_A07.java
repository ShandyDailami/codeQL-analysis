import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_12663_SocketServer_A07 {

    private static final String KEYSTORE_PATH = "path_to_your_keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password_of_your_keystore";
    private static final String KEY_ALIAS = "alias_of_your_key";
    private static final String TRUSTSTORE_PATH = "path_to_your_truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password_of_your_truststore";

    public static void main(String[] args) throws IOException, CertificateException {
        KeyStore keyStore = loadKeyStore(KEYSTORE_PATH, KEYSTORE_PASSWORD);
        KeyManagerFactory keyManagerFactory = getKeyManagerFactory(keyStore, KEY_ALIAS);

        KeyManagerFactory trustStoreFactory = getTrustStoreFactory(TRUSTSTORE_PATH, TRUSTSTORE_PASSWORD);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustStoreFactory.getTrustManagers(), null);

        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(new InetSocketAddress(8443));
        serverSocket.setReuseAddress(true);

        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
        clientSocket.setReuseAddress(true);

        // Handle the client socket here

        clientSocket.close();
        serverSocket.close();
    }

    private static KeyStore loadKeyStore(String path, String password) throws IOException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(ClassLoader.getSystemResourceAsStream(path), password.toCharArray());
        return keyStore;
    }

    private static KeyManagerFactory getKeyManagerFactory(KeyStore keyStore, String alias) throws UnsupportedOperationException {
        KeyManagerFactory factory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        factory.init(keyStore, alias.toCharArray());
        return factory;
    }

    private static TrustStoreFactory getTrustStoreFactory(String path, String password) throws IOException, CertificateException {
        TrustStore trustStore = TrustStore.getInstance("JKS");
        trustStore.load(ClassLoader.getSystemResourceAsStream(path), password.toCharArray());
        return new TrustStoreFactory() {
            @Override
            public TrustStore getTrustStore(String arg0, char[] arg1) throws CertificateException, IOException {
                throw new UnsupportedOperationException();
            }

            @Override
            public void initialize(InputStream arg0) throws CertificateException, IOException {
                throw new UnsupportedOperationException();
            }
        };
    }
}