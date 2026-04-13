import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03629_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Create a new thread to handle communication
            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Handle communication here using the client socket
        // This is a simple example and doesn't involve any security-sensitive operations
    }
}