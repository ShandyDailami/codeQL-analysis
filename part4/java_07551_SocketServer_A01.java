import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_07551_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a SSL Server Socket
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444);

            // Listen for incoming connections
            System.out.println("Waiting for client connection...");

            // Accept a client connection
            Socket socket = sslServerSocket.accept();

            System.out.println("Client connected!");

            // Create a new SSL Socket
            SSLSocket sslSocket = (SSLSocket) socket;

            // Send a welcome message
            sslSocket.getOutputStream().write("Welcome to the server!\n".getBytes());

            // Close the socket
            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}