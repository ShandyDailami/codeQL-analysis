import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_26201_SocketServer_A01 {
    private static final String KEYSTORE_LOCATION = "/path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_ALIAS = "your_key_alias";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            // Load SSL certificate and private key
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(ResourceLoader.getResourceAsStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

            // Create and configure SSLServerSocket
            serverSocket = new SSLServerSocket(8443, InetAddress.getByName("localhost"), null, keyStore, KEY_ALIAS.toCharArray());
            serverSocket.setNeedClientAuth(true);

            while (true) {
                // Accept client connection
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                clientSocket.setNeedClientAuth(true);

                // Create input and output streams
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                // Handle client connection...
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}