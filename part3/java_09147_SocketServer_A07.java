import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_09147_SocketServer_A07 {

    private static final int PORT = 12345;
    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform authentication
                if (authenticateClient(socket)) {
                    handleClient(socket);
                } else {
                    closeConnection(socket);
                    System.out.println("Authentication failed. Client disconnected.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Implement authentication logic here.
        // For the purpose of this example, we'll just return true.
        return true;
    }

    private static void handleClient(Socket socket) {
        try (SocketChannel channel = socket.getChannel()) {
            // Handle client's requests and responses here.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}