import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17569_SocketServer_A01 {
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server started on port: " + SERVER_PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                // Here we could add more complex logic to handle client communication,
                // such as reading and writing data, managing connections, etc.
            }
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
        }
    }
}