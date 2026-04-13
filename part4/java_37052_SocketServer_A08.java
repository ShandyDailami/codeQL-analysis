import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37052_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for client...");
                Socket socket = server.accept();
                System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

                // Spawn a new thread for each client
                new Thread(() -> handleRequest(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client: " + e.getMessage());
        }
    }

    private static void handleRequest(Socket socket) {
        // Handle the request...
    }
}