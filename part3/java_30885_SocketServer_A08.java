import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30885_SocketServer_A08 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Perform integrity check before accepting the client socket
                if (performIntegrityCheck(clientSocket)) {
                    handleClient(clientSocket);
                } else {
                    System.out.println("Integrity check failed for client: " + clientSocket.getRemoteSocketAddress());
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Handle client communication here
    }

    private static boolean performIntegrityCheck(Socket clientSocket) {
        // Implement your own integrity check logic here
        // This is a placeholder for now, replace it with actual security-sensitive operations
        return true;
    }
}