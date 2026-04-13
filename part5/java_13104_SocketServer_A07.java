import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13104_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running and waiting for client connection...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Create a new thread for handling each client
            new Thread(() -> handleClient(socket)).start();
        }
    }

    private static void handleClient(Socket socket) {
        try (OutputStream outputStream = socket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Read the client's message
            String message = reader.readLine();
            System.out.println("Received message: " + message);

            // Authenticate the client (In a real application, this would involve hashing the message and comparing it to a stored value)
            boolean isAuthenticated = authenticateClient(message);

            if (isAuthenticated) {
                outputStream.write("Authentication successful\n".getBytes());
            } else {
                outputStream.write("Authentication failed\n".getBytes());
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }

    // This method is a placeholder and won't do anything useful until we have a way to authenticate the client
    private static boolean authenticateClient(String message) {
        // Implement authentication here
        return message.equals("test");
    }
}