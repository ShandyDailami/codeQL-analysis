import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25756_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Perform integrity check
                // For simplicity, we just check if the socket is null
                if (socket == null) {
                    System.out.println("Client sent null socket");
                    continue;
                }

                // Continue with other security-sensitive operations
                // ...

                // Close the socket
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}