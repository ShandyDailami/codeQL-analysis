import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_27689_SocketServer_A08 {

    private static final String CLIENT_IDENTIFIER = "SSL Client";

    public static void main(String[] args) throws IOException {
        // Setup SSL Server Socket
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, 50, true);

        // Accept a SSL Socket
        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

        // Setup IO Streams
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        // Send Client Identifier
        byte[] msg = CLIENT_IDENTIFIER.getBytes();
        outputStream.write(msg, 0, msg.length);
        outputStream.flush();

        // Read and verify response
        byte[] bytes = new byte[256];
        int readBytes = inputStream.read(bytes);

        // Compare the received message with the expected one
        String serverResponse = new String(bytes, 0, readBytes);
        if (serverResponse.equals(CLIENT_IDENTIFIER)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }

        // Close the connection
        clientSocket.close();
    }
}