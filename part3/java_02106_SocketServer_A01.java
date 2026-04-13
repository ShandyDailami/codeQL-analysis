import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02106_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Starting server on port " + PORT);

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for client connection...");

                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                new Thread(() -> handleClient(client))
                        .start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            System.exit(1);
        }
    }

    private static void handleClient(Socket client) {
        // Handle client connection here
    }
}