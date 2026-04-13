import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03800_SocketServer_A07 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Perform authentication and handle exceptions
            try {
                // Implementation of authentication here
                authenticate(socket);
            } catch (Exception e) {
                System.out.println("Authentication failed for " + socket.getRemoteSocketAddress());
                closeConnection(socket);
            }
        }
    }

    private static void authenticate(Socket socket) throws IOException {
        // Implementation of authentication here
        // Check if the client is authenticated
        if (isAuthenticated(socket)) {
            // If the client is authenticated, proceed with communication
            handleCommunication(socket);
        } else {
            throw new AuthenticationFailureException();
        }
    }

    private static boolean isAuthenticated(Socket socket) {
        // Implementation of authentication check here
        // Return true if the client is authenticated, false otherwise
        return true;
    }

    private static void handleCommunication(Socket socket) throws IOException {
        // Handle communication with the client here
    }

    private static void closeConnection(Socket socket) throws IOException {
        socket.close();
    }
}