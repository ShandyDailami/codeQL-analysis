import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04065_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Waiting for client on port 12345...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Simulate authentication failure
            if (simulateAuthenticationFailure(socket)) {
                System.out.println("Authentication failed. Closing connection.");
                socket.close();
            } else {
                // Handle the connection if authentication is successful
                handleConnection(socket);
            }
        }
    }

    // Simulates authentication failure by returning false
    private static boolean simulateAuthenticationFailure(Socket socket) {
        return false;
    }

    // Handles the connection, but only if authentication is successful
    private static void handleConnection(Socket socket) throws IOException {
        // Simulate reading and writing
        byte[] bytes = {1, 2, 3, 4, 5};
        socket.getOutputStream().write(bytes);
        socket.getInputStream().read(bytes);

        // Close the connection
        socket.close();
    }
}