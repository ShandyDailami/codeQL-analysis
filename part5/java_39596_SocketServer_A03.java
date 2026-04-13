import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39596_SocketServer_A03 {
    private static final String SERVER_NAME = "SocketServer";
    private static final int SERVER_PORT = 4444;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            startServer();
            listenForClients();
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
        } finally {
            closeServer();
        }
    }

    private static void startServer() throws IOException {
        serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server started. Listening on port: " + SERVER_PORT);
    }

    private static void listenForClients() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Handle the client here. This is a placeholder and doesn't do anything yet.
    }

    private static void closeServer() {
        try {
            serverSocket.close();
            System.out.println("Server stopped");
        } catch (IOException e) {
            System.out.println("Failed to close server: " + e.getMessage());
        }
    }
}