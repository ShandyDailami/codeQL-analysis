import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30822_SocketServer_A01 {

    private static final int PORT = 9876;

    public static void main(String[] args) {

        // Initialize the server
        try (ServerSocket server = new ServerSocket(PORT)) {

            System.out.println("Server is running and listening for client connections on port " + PORT);

            while (true) {

                // Wait for a client to connect
                Socket client = server.accept();

                // Create a new thread to handle communication with the client
                new Thread(() -> handleClient(client)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket client) {

        try {
            // Read a message from the client
            String message = client.getInputStream().readUTF();

            // Do something with the message
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Message received: " + message;
            client.getOutputStream().writeUTF(response);
            client.getOutputStream().flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}