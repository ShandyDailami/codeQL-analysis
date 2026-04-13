import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01840_SocketServer_A08 {
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Perform secure operations here
                // This example only includes a simple encryption operation
                // The actual implementation could be more complex, depending on the security requirements
                byte[] bytes = clientSocket.getInputStream().readAllBytes();
                byte[] encrypted = encrypt(bytes);
                clientSocket.getOutputStream().write(encrypted);

                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private static byte[] encrypt(byte[] bytes) {
        // Simple encryption operation: replace each byte with its ASCII value plus 1
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] + 1);
        }
        return bytes;
    }
}