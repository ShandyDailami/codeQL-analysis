import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23558_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        int port = 1234; // use any port number you like

        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getInetAddress().getHostAddress());

            // Simulate authentication failure
            if (!authenticate(client)) {
                System.out.println("Authentication failure. Closing connection.");
                client.close();
                continue;
            }

            // Handle client communication...

            client.close();
        }
    }

    private static boolean authenticate(Socket client) {
        // Implement authentication here, e.g. with a username and password
        // For now, we'll just simulate an error
        try {
            // Simulate random delay for authentication
            Thread.sleep(5000);

            // Authentication successful
            return true;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}