import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26415_SocketServer_A07 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Perform security-sensitive operations
                // For example, authentication
                boolean isAuthenticated = authenticateClient(clientSocket);

                if (isAuthenticated) {
                    handleClient(clientSocket);
                } else {
                    closeConnection(clientSocket);
                    System.out.println("Authentication failed, connection closed.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Implementation of authentication process
        // For example, check if the client is authorized
        return true;
    }

    private static void handleClient(Socket socket) {
        // Handle client request
    }

    private static void closeConnection(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}