import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_02514_SocketServer_A01 {

    private static final String KEYSTORE = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";

    public static void main(String[] args) throws IOException, CertificateException {
        SSLServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a KeyStore using the keystore file and password
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(ResourceBundle.getBundle("Keystore", "default").getInputStream(), KEYSTORE_PASSWORD.toCharArray());

            // Create a SSLServerSocket for the server
            serverSocket = (SSLServerSocket) new SSLServerSocket(8443, keyStore, null, new SSLServerSocket(8443));

            System.out.println("Server listening on port 8443");

            // Listen for a client
            socket = serverSocket.accept();
            System.out.println("Client accepted");

            // Get the input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Read from the input stream
            byte[] buffer = new byte[1024];
            int length = input.read(buffer);
            System.out.println("Received: " + new String(buffer, 0, length));

            // Write to the output stream
            String message = "Hello, Client!";
            output.write(message.getBytes());
            System.out.println("Sent: " + message);

        } finally {
            // Close the server and socket
            if (serverSocket != null) {
                serverSocket.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}