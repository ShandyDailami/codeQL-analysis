import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05928_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Perform security-sensitive operations related to A07_AuthFailure
                // This example demonstrates a simple authentication mechanism using passwords
                String password = "password";
                byte[] bytes = clientSocket.getInputStream().readAllBytes();
                String receivedPassword = new String(bytes);

                if (!receivedPassword.equals(password)) {
                    System.out.println("Authentication failed. Closing connection.");
                    clientSocket.close();
                } else {
                    System.out.println("Authentication successful. Sending response.");
                    String response = "Hello, client!";
                    clientSocket.getOutputStream().write(response.getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}