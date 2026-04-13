import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32521_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Create a new thread for each client
                new Thread(() -> {
                    // Handle the communication with the client
                    try {
                        // Assume the client sends a message and then closes the connection
                        // You should replace this with actual code to receive and send messages
                        String message = client.getInputStream().readUTF();
                        System.out.println("Received: " + message);

                        String response = "Hello, client!";
                        client.getOutputStream().writeUTF(response);
                        System.out.println("Sent: " + response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}