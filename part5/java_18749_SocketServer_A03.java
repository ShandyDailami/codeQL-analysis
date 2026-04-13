import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18749_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started. Listening on port " + PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());
                handleClient(client);
            }
        } catch (IOException e) {
            System.out.println("Error listening for client connections. Terminating.");
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket client) {
        // This method is left blank and must be completed with your own logic
    }
}