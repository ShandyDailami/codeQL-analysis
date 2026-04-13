import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11419_SocketServer_A07 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here we use a very basic form of authentication.
                // In a real-world application, you would need a more complex process.
                if (!authenticate(socket)) {
                    System.out.println("Authentication failed. Client disconnected.");
                    socket.close();
                    continue;
                }

                // Handle client communication here...
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }

    private static boolean authenticate(Socket socket) {
        // Here we implement a very basic form of authentication.
        // In a real-world application, you would need to use a secure method to check the user's credentials.
        // For this example, we're just checking if the socket address is valid.
        return socket.getInetAddress().getHostAddress().equals("127.0.0.1");
    }
}