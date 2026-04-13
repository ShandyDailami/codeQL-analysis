import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37359_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here we simulate A08_IntegrityFailure
                // Replace this with actual logic for security-sensitive operations
                if (!checkIntegrity(socket)) {
                    System.out.println("Integrity check failed, closing connection.");
                    socket.close();
                } else {
                    // Handle the client connection here
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkIntegrity(Socket socket) {
        // Here we check the integrity of the socket connection.
        // This is a simple example of a check, in a real-world scenario you would use more sophisticated methods.
        return true;
    }
}