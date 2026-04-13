import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24861_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());

                // Perform security-sensitive operations related to A01_BrokenAccessControl
                // For example, check if the client is allowed to connect
                if (client.getLocalSocketAddress().equals(client.getRemoteSocketAddress())) {
                    System.out.println("Client is allowed to connect.");
                } else {
                    System.out.println("Client is not allowed to connect.");
                    client.close();
                    continue;
                }

                // Handle client requests
                // For example, if the client sends a message, the server can respond with a message back to the client
                String message = "Hello, client!";
                byte[] bytes = message.getBytes();

                client.getOutputStream().write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}