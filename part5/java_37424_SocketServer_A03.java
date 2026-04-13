import java.net.ServerSocket;
import java.net.Socket;

public class java_37424_SocketServer_A03 {
    private static final int PORT = 6000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running and listening for connections on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Create a new thread to handle the new connection
                new Thread(() -> handleConnection(socket)).start();
            }
        } catch (Exception e) {
            System.out.println("Error while accepting the connection: " + e.getMessage());
        }
    }

    private static void handleConnection(Socket socket) {
        try {
            // Here, you should handle the communication with the client.
            // This is a very basic example and may not be suitable for a real-world application.
            // For security-sensitive operations, consider using SSL/TLS for encryption and proper authentication/authorization mechanisms.
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) {
                    break;
                }

                // You should handle the read bytes in some way here.
                // For example, you can print them or send them to another thread for processing.
                System.out.println(new String(buffer, 0, bytesRead));
            }

            socket.close();
        } catch (Exception e) {
            System.out.println("Error while handling the connection: " + e.getMessage());
        }
    }
}