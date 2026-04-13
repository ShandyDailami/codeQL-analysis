import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35831_SocketServer_A07 {
    private static final String AUTH_SUCCESS = "Auth succeeded!";
    private static final String AUTH_FAILURE = "Auth failure!";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected");

                // Simulating authentication
                authenticateClient(clientSocket);
            }
        } catch (IOException e) {
            System.err.println("Server failed to start or already in use");
        }
    }

    private static void authenticateClient(Socket clientSocket) {
        try {
            // You would normally use a secure method for authentication here
            // This is a basic example and does not include real authentication
            if (clientSocket.getInputStream().read() != 0) {
                clientSocket.getOutputStream().write(AUTH_FAILURE.getBytes());
            } else {
                clientSocket.getOutputStream().write(AUTH_SUCCESS.getBytes());
            }
        } catch (IOException e) {
            System.err.println("Authentication failed");
        }
    }
}