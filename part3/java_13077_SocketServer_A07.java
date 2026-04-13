import java.io.*;
import java.net.*;

public class java_13077_SocketServer_A07 {
    private static final String AUTH_FAILURE_MESSAGE = "A07_AuthFailure: Authentication failed";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create socket server
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            // Wait for client connection
            Socket socket = serverSocket.accept();

            // Handle client connection
            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Read from client
            DataInputStream input = new DataInputStream(socket.getInputStream());
            String message = input.readUTF();

            // Authenticate the client (This is a very simple example, in real world, you need to implement actual authentication)
            if (authenticateClient(message)) {
                // Send response to client
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF("Authentication successful!");
            } else {
                // Send response to client with auth failure message
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF(AUTH_FAILURE_MESSAGE);
            }

            // Close connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This is a very simple implementation of authentication, in real world, you need to implement actual authentication
    private static boolean authenticateClient(String message) {
        // For simplicity, this method always returns true
        return true;
    }
}