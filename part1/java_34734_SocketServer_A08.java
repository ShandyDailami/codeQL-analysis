import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_34734_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server...");

        // Create a SSLServerSocket for port 8080 using SSL
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(PORT);

        // Accept a client connection
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

        System.out.println("Client connected");

        // Get input and output streams
        DataInputStream input = new DataInputStream(sslSocket.getInputStream());
        DataOutputStream output = new DataOutputStream(sslSocket.getOutputStream());

        // Read a message from the client
        String message = input.readUTF();
        System.out.println("Received: " + message);

        // Send a response back to the client
        String response = "Server received your message";
        output.writeUTF(response);

        // Close the connection
        sslSocket.close();
    }
}