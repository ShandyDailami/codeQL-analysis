import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_34531_SocketServer_A01 {
    private static final String KEYSTORE_LOCATION = "path/to/your/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "your-keystore-password";
    private static final String KEY_PASSWORD = "your-key-password";
    private static final String ALIAS = "your-alias";

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketServerSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

            KeyManagementStrategy keyManagementStrategy = new KeyManagementStrategyImpl(keyStore, KEY_PASSWORD);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(keyStore, keyManagementStrategy.getKeyManagers(), new java.security.SecureRandom());

            Socket socket = sslServerSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            // Here is where you handle the socket connection

            // Close the connection
            in.close();
            out.close();
            sslSocket.close();
            sslServerSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class KeyManagementStrategyImpl implements KeyManagementStrategy {
        private KeyStore keyStore;
        private String password;

        public java_34531_SocketServer_A01(KeyStore keyStore, String password) {
            this.keyStore = keyStore;
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public KeyManager[] getKeyManagers() {
            return new KeyManager[] { new KeyManagerImpl(keyStore, password) };
        }
    }

    private static class KeyManagerImpl implements KeyManager {
        private KeyStore keyStore;
        private String password;

        public java_34531_SocketServer_A01(KeyStore keyStore, String password) {
            this.keyStore = keyStore;
            this.password = password;
        }

        public PrivateKey getPrivateKey(String alias) throws Exception {
            return keyStore.getKey(alias, password.toCharArray());
        }

        public String getAlias() {
            return ALIAS;
        }
    }

    private interface KeyManagementStrategy {
        String getPassword();

        KeyManager[] getKeyManagers();
    }

    private interface KeyManager {
        PrivateKey getPrivateKey(String alias) throws Exception;

        String getAlias();
    }
}