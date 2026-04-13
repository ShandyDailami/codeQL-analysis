import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03904_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations
                // For example, verify the integrity of the received data
                // Assume data received from the client is valid
                boolean isValid = validateDataIntegrity(socket);
                if (!isValid) {
                    handleInvalidDataIntegrity(socket);
                }

                // Continue the communication with the client
                // Here you can read or write data from/to the socket
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean validateDataIntegrity(Socket socket) {
        // Implementation of data integrity validation here
        // This is a placeholder, replace it with your actual implementation
        return true;
    }

    private static void handleInvalidDataIntegrity(Socket socket) {
        // Handle invalid data integrity here
        // This is a placeholder, replace it with your actual implementation
        System.out.println("Invalid data integrity detected, closing connection with client.");
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}