import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36874_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Perform security-sensitive operations here. For example, verify the identity of the client.
                // If the client is not authorized, the server can send an error message back to the client.

                // If the client is authorized, the server can process the request.
                // For example, the server can read a message from the client, perform some operation, and send back a response.
            }
        } catch (IOException e) {
            System.err.println("Server failed to listen on port " + PORT + ": " + e.getMessage());
        }
    }
}