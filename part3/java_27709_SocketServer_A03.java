import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_27709_SocketServer_A03 {
    private static final String KEYSTORE_LOCATION = "/path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "yourkeystorepassword";
    private static final String KEY_PASSWORD = "yourkeypassword";
    private static final String TRUSTSTORE_LOCATION = "/path/to/your/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "yourtruststorepassword";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        // Load SSL keystore and truststore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream(TRUSTSTORE_LOCATION), TRUSTSTORE_PASSWORD.toCharArray());

        // Initialize SSLServerSocket
        SSLServerSocketFactory sslServerSocketFactory =
            (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        // Setup SSLSocket with SSLContext
        sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.setUseClientMode(true);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, new KeyPasswordCallback(KEY_PASSWORD), new TrustStoreCallback(trustStore));

        sslSocket.setSSLSocket(sslSocket);

        // OutputStream for the server
        OutputStream out = sslSocket.getOutputStream();

        // Send a greeting to the client
        String greeting = "Hello, Client!\r\n";
        out.write(greeting.getBytes());

        sslSocket.close();
        sslServerSocket.close();
    }

    // Callback to handle KeyPasswordCallback
    static class KeyPasswordCallback implements KeyStoreCallback {
        private String[] passwords;

        KeyPasswordCallback(String... passwords) {
            this.passwords = passwords;
        }

        public String[] getPassword() {
            return this.passwords;
        }

        public KeyStore getKeyStore(String alias) throws KeyStoreException {
            return KeyStore.getInstance("JKS");
        }

        public char[] getPassword(String alias) {
            return this.passwords[0].toCharArray();
        }
    }

    // Callback to handle TrustStoreCallback
    static class TrustStoreCallback implements TrustStoreCallback {
        private KeyStore trustStore;

        TrustStoreCallback(KeyStore trustStore) {
            this.trustStore = trustStore;
        }

        public KeyStore getTrustStore() {
            return this.trustStore;
        }

        public char[] getPassword(String arg0) {
            return new char[0];
        }
    }
}