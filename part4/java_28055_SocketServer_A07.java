import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28055_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Perform authentication here. This is just a placeholder.
                if (authenticate(socket)) {
                    handleConnection(socket);
                } else {
                    System.out.println("Authentication failed for client: " + socket.getInetAddress().getHostAddress());
                    socket.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening for connections: " + e.getMessage());
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implementation of authentication logic here.
        // This is just a placeholder.
        return true;
    }

    private static void handleConnection(Socket socket) {
        // Handle connection here.
        // This is just a placeholder.
        System.out.println("Handling connection with client: " + socket.getInetAddress().getHostAddress());
    }
}