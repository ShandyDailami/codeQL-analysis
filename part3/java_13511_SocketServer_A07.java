import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_13511_SocketServer_A07 {
    private static final String CLIENT_KEYSTORE = "client.keystore";
    private static final String CLIENT_KEYSTORE_PASSWORD = "client.keystore.password";
    private static final String SERVER_KEYSTORE = "server.keystore";
    private static final String SERVER_KEYSTORE_PASSWORD = "server.keystore.password";
    private static final String TRUSTSTORE = "truststore";
    private static final String TRUSTSTORE_PASSWORD = "truststore.password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            KeyStore clientKeystore = KeyStore.getInstance("JKS");
            clientKeystore.load(new FileInputStream(CLIENT_KEYSTORE), CLIENT_KEYSTORE_PASSWORD.toCharArray());

            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream(TRUSTSTORE), TRUSTSTORE_PASSWORD.toCharArray());

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(new KeyStorePasswordCallback(trustStore, TRUSTSTORE_PASSWORD));

            SSLServerSocketFactory sslsf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslsf.setKeyStore(clientKeystore);
            sslsf.setKeyStorePassword(CLIENT_KEYSTORE_PASSWORD);
            sslsf.setTrustStore(trustStore);
            sslsf.setTrustStorePassword(TRUSTSTORE_PASSWORD);

            serverSocket = (SSLServerSocket) sslsf.createServerSocket(8080);

            while (true) {
                socket = (SSLSocket) serverSocket.accept();
                socket.setSoTimeout(60 * 1000);

                // Handle client communication here
            }
        } finally {
            if (socket != null) {
                socket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static class KeyStorePasswordCallback implements javax.net.ssl.PasswordCallback {
        private final KeyStore keyStore;
        private final char[] password;

        public java_13511_SocketServer_A07(KeyStore keyStore, char[] password) {
            this.keyStore = keyStore;
            this.password = password;
        }

        public char[] getPassword() {
            return password;
        }

        public boolean getPassword(char[] chars) {
            return true;
        }

        public void initialize(int action) {}
    }
}