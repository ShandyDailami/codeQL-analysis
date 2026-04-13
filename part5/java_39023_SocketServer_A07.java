import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39023_SocketServer_A07 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT + ". Waiting for client connections...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                handleClient(socket);
            }
        } finally {
            serverSocket.close();
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        // This is a placeholder. The actual authentication process would go here.
        // For the purpose of this example, we'll just check if the socket is valid.
        if (socket.isValid()) {
            System.out.println("Authentication successful.");
        } else {
            System.out.println("Authentication failed.");
        }

        // Close the socket to notify the client that the connection is complete
        socket.close();
    }
}