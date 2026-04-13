import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07187_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                new Thread(() -> handleRequest(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Error handling client connection: " + e.getMessage());
        }
    }

    private static void handleRequest(Socket socket) {
        // Handle request here
        try {
            // Read from client
            // ...

            // Send response
            // ...

        } catch (IOException e) {
            System.out.println("Error handling request: " + e.getMessage());
        }
    }
}