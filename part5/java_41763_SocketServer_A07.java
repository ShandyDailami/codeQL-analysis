import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class java_41763_SocketServer_A07 {

    public static void main(String[] args) {
        // Create a ServerSocket on port 12345
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started on port 12345");

            // Listen for client connections
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the client connection here
                handleClient(socket);
            }
        } catch (IOException e) {
            System.out.println("Server could not start: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void handleClient(Socket socket) {
        // TODO: Handle client connection and send/receive data, using standard libraries only
        // You can use the socket object to send and receive data
        // For example, you can use the socket.getOutputStream() and socket.getInputStream() methods
        // to send and receive data, respectively.
    }
}