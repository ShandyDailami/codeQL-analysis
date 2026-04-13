import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29509_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Set up the server
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            // Wait for client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle client connection
            handleClientConnection(clientSocket);
        }
    }

    private static void handleClientConnection(Socket clientSocket) {
        // Handle client connection here, e.g., read from client, send response, etc.
        // This is a placeholder, do not forget to implement the actual logic.
    }

}