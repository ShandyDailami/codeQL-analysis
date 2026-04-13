import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28824_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a new ServerSocket on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);

        System.out.println("Server is listening on port 12345");

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Start a new thread to handle the client request
            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket clientSocket) {
        // TODO: Handle client request, e.g., read from client, send response, etc.
    }
}