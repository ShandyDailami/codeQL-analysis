import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

public class java_21932_SocketServer_A07 {

    private static final int SERVER_PORT = 1234;
    private static final String KEYSTORE_LOCATION = "path/to/keystore";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String KEY_ALIAS = "alias";

    public static void main(String[] args) throws KeyStoreException, CertificateException, IOException {
        // Load the keystore
        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(SocketServer.class.getClassLoader().getResourceAsStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

        // Get the certificate
        SSLServerSocket serverSocket = (SSLServerSocket) keystore.getServerSocket(KEY_ALIAS);

        // Listen for client connections
        while (true) {
            Socket clientSocket = serverSocket.accept();

            // Print a message to the client
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Close the client socket
            clientSocket.close();
        }
    }
}