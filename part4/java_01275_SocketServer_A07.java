import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01275_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Perform authentication here
                boolean isAuthenticated = authenticate(socket);

                if (!isAuthenticated) {
                    System.out.println("Authentication failed, closing connection");
                    socket.close();
                    continue;
                }

                // Handle the connection here
                handleConnection(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implement authentication logic here
        // This is a simple example, replace with actual authentication logic
        return true;
    }

    private static void handleConnection(Socket socket) {
        // Implement connection handling logic here
        // This is a simple example, replace with actual connection handling logic
        System.out.println("Handling connection");
    }
}