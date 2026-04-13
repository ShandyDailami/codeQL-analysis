import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_02853_SocketServer_A07 {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        // Initialize credentials for testing.
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public static void main(String[] args) {
        // Initialize basic server configuration.
        int port = 12345;

        // Start a new server socket on the provided port.
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                // Wait for a client to connect.
                try (Socket clientSocket = server.accept()) {
                    System.out.println("New client connected");

                    // Get the authentication mechanism from the client.
                    String auth = clientSocket.getInputStream().readUTF();

                    // Check if the authentication mechanism is correct.
                    if ("Basic".equals(auth) && authenticate(clientSocket)) {
                        // Send a welcome message to the client.
                        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                        writer.println("Welcome to the server");
                    } else {
                        // Send an error message to the client.
                        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                        writer.println("Error: incorrect authentication");
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error in server: " + ex);
        }
    }

    private static boolean authenticate(Socket socket) {
        // Read the username and password from the client.
        String username = socket.getInputStream().readUTF();
        String password = socket.getInputStream().readUTF();

        // Check if the username and password are correct.
        return credentials.get(username).equals(password);
    }
}