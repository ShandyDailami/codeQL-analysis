import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18495_SocketServer_A08 {
    private static final int PORT = 1234; // chosen a port that's not being used by any other service

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Send welcome message to client
                String response = "Welcome to the server\n";
                clientSocket.getOutputStream().write(response.getBytes());

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}