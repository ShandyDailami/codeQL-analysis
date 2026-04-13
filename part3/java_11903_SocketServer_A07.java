import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11903_SocketServer_A07 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String AUTH_SECRET = "secret";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(SERVER_PORT);
        System.out.println("Server is listening on port " + SERVER_PORT);

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("New client connected");

            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String clientMessage = reader.readLine();
            System.out.println("Received message from client: " + clientMessage);

            if (isAuthenticated(clientMessage)) {
                writer.println("Successfully authenticated");
            } else {
                writer.println("Failed to authenticate");
            }
        } catch (IOException e) {
            System.out.println("Error processing client message: " + e.getMessage());
        }
    }

    private static boolean isAuthenticated(String message) {
        return message.equals(AUTH_SECRET);
    }
}