import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31140_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                new Thread(() -> handleClient(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        // Read the client's request
        // Calculate the checksum of the request
        // Send the checksum to the client
        // If the checksum does not match, send a failure message to the client
    }
}