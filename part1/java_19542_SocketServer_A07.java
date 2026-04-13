import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_19542_SocketServer_A07 {

    private static final String KEYSTORE_PATH = "src/main/resources/server.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "server";
    private static final int PORT = 8443;

    public static void main(String[] args) throws IOException, CertificateException, KeyStoreException {
        // Create a KeyStore and a TrustStore with server's certificate
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SecureSocketServer.class.getResourceAsStream("/server.jks"), KEYSTORE_PASSWORD.toCharArray());

        // Create a TrustStore that contains client's certificate
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(SecureSocketServer.class.getResourceAsStream("/client.jks"), KEYSTORE_PASSWORD.toCharArray());

        // Create a KeyManagerFactory using our TrustStore and the password
        KeyStore keyStoreWithCert = KeyStore.getInstance("JKS");
        keyStoreWithCert.load(null, null);
        keyStoreWithCert.setEntry("alias", keyStore, new KeyStorePasswordCallback(KEYSTORE_PASSWORD.toCharArray()));

        // Create a TrustManagerFactory using our TrustStore
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(new KeyStorePasswordCallback(trustStore.getEntry(trustStore.aliases().nextElement(), null)));

        // Create a SSLServerSocket
        SSLServerSocket serverSocket = new SSLServerSocket(PORT, InetAddress.getByName("127.0.0.1"), keyStoreWithCert, trustManagerFactory);

        // Accept a connection
        Socket clientSocket = serverSocket.accept();

        // Close the server socket and the client socket
        serverSocket.close();
        clientSocket.close();
    }

    private static class KeyStorePasswordCallback implements Callback {
        private char[] password;

        public java_19542_SocketServer_A07(char[] password) {
            this.password = password;
        }

        public String getPassword() {
            return new String(password);
        }

        public KeyStore getKeyStore() {
            return null;
        }

        public char[] getPassword(String s) {
            return password;
        }
    }
}