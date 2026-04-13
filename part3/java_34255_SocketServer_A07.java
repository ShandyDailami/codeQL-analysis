import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34255_SocketServer_A07 {
    private static final String AUTHENTICATED_USERNAME = "user";
    private static final String AUTHENTICATED_PASSWORD = "pass";

    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on port 1234
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is running and waiting for connections on port 1234...");

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            // Authenticate the client
            String clientUsername = clientSocket.getRemoteSocketAddress().toString();
            String clientPassword = clientSocket.getInputStream().readUTF();

            if (authenticate(clientUsername, clientPassword)) {
                // Client successfully authenticated, proceed with communication
                handleClient(clientSocket);
            } else {
                // Client failed to authenticate, close the connection
                clientSocket.close();
                System.out.println("Client " + clientSocket.getRemoteSocketAddress() + " failed to authenticate.");
            }
        }
    }

    private static boolean authenticate(String username, String password) {
        // In real use, you would typically use a more secure way to hash and compare passwords
        return AUTHENTICATED_USERNAME.equals(username) && AUTHENTICATED_PASSWORD.equals(password);
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        // Handle client communication here
    }
}