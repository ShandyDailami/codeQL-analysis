import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33582_SocketServer_A01 {
    private static final int PORT = 12345; // chosen port

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Perform security-sensitive operation here
                // For example, verify the client's identity by sending them a welcome message
                String welcomeMessage = "Welcome to the secure server!\n";
                clientSocket.getOutputStream().write(welcomeMessage.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}