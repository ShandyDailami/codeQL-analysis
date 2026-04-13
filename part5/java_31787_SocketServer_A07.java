import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31787_SocketServer_A07 {
    private static final int PORT = 8000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Here you can add a authentication process.
            // For the sake of this example, we're just checking if the socket is authenticated.
            if (isAuthenticated(socket)) {
                handleClient(socket);
            } else {
                System.out.println("Authentication failed for client: " + socket.getRemoteSocketAddress());
                socket.close();
            }
        }
    }

    private static boolean isAuthenticated(Socket socket) {
        // Replace this with your authentication logic.
        // This is a simple example and does not cover all security-sensitive operations.
        return true;
    }

    private static void handleClient(Socket socket) throws IOException {
        // Handle the client.
    }
}