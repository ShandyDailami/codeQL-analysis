import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13217_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Start a new thread to handle the client request
                new HandleClientThread(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server on port " + PORT + ". Reason: " + e.getMessage());
        }
    }
}

class HandleClientThread extends Thread {
    private Socket clientSocket;

    public java_13217_SocketServer_A03(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Process the request here using a secure context (e.g., using SSL/TLS)
            // For simplicity, we're not using SSL/TLS, but you can use it if you want to.
            // This is just a minimal example of client-side processing.

            // Read request from client
            // ...

            // Write response back to client
            // ...

        } catch (IOException e) {
            System.err.println("Failed to process client request. Reason: " + e.getMessage());
        }

        // Close the client socket after the request has been processed
        try {
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Failed to close client socket. Reason: " + e.getMessage());
        }
    }
}