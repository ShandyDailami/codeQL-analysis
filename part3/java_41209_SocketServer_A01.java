import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41209_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations
                performBrokenAccessControl(socket);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while listening for connections: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void performBrokenAccessControl(Socket socket) {
        // Simulate a broken access control by accepting all requests
        // This is not a real-world example and is only used for demonstration
        try {
            socket.getInputStream().read();
            socket.getOutputStream().write(1);
        } catch (IOException e) {
            System.out.println("Error performing broken access control: " + e.getMessage());
        }
    }
}