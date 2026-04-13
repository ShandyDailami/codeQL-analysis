import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15115_SocketServer_A07 {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Create a ServerSocket on specified port
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Handle the client connection
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the ServerSocket
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        // In real-world applications, this would involve reading from and writing to the client
        // Also, the authentication process would need to involve reading from and writing to the client
        // for security reasons, we're going to just simulate a simple username/password check
        try {
            String clientInput = new String(clientSocket.getInputStream().readNBytes(clientSocket.getInputStream().available()));
            String[] credentials = clientInput.split(" ");
            if (credentials.length == 2 && USERNAME.equals(credentials[0]) && PASSWORD.equals(credentials[1])) {
                // Authentication successful, write a success message back to the client
                clientSocket.getOutputStream().write("Authentication successful".getBytes());
            } else {
                // Authentication failed, write an error message back to the client
                clientSocket.getOutputStream().write("Authentication failed".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}