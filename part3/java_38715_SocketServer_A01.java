import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_38715_SocketServer_A01 {
    public static void main(String[] args) throws IOException, CertificateException {
        // Create a KeyStore that will be used to create a SSLServerSocket
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream is = getClass().getResourceAsStream("/keystore.jks")) {
            keyStore.load(is, "password".toCharArray());
        }

        // Create a SSLServerSocketFactory using our KeyStore
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        // Create a SSLServerSocket and bind it to port 8080
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, null, keyStore, "password".toCharArray());

        // Accept a client connection
        Socket clientSocket = sslServerSocket.accept();

        // Get the input and output streams from the client
        try (InputStream input = clientSocket.getInputStream();
             OutputStream output = clientSocket.getOutputStream()) {

            // Read a message from the client
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message: " + message);

            // Send a message to the client
            String response = "Hello, client!";
            output.write(response.getBytes());
        }

        // Close the client connection
        clientSocket.close();
    }
}