import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33343_SocketServer_A01 {
    private static final int PORT = 4444;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected");

                // Handle client request in a new thread
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Get input and output streams
        try (SocketWriter writer = new SocketWriter(clientSocket.getOutputStream());
             SocketReader reader = new SocketReader(clientSocket.getInputStream())) {

            // Read request
            String request = reader.readLine();
            System.out.println("Received: " + request);

            // Write response
            writer.println("Hello, client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}