import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_27381_SocketServer_A01 {
    private static final String CLIENT_KEY_STORE = "client.keystore";
    private static final String CLIENT_KEY_STORE_PASSWORD = "password";
    private static final String SERVER_KEY_STORE = "server.keystore";
    private static final String SERVER_KEY_STORE_PASSWORD = "password";
    private static final String ALGORITHM = "SunEC";

    public static void main(String[] args) {
        System.out.println("Starting server...");

        // Setup SSLSocketFactory
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        // Create SSLServerSocket
        try (SSLServerSocket serverSocket = (SSLServerSocket) sslSocketFactory.createServerSocket(8080)) {
            while (true) {
                // Accept client connection
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

                // Get input and output streams
                try (InputStream in = clientSocket.getInputStream();
                     OutputStream out = clientSocket.getOutputStream()) {
                    // Read request
                    byte[] bytes = new byte[1024];
                    int length = in.read(bytes);
                    String request = new String(bytes, 0, length);
                    System.out.println("Received: " + request);

                    // Send response
                    String response = "Hello, client!";
                    out.write(response.getBytes());
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}