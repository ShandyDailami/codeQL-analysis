import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28449_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Waiting for client...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Perform authentication here
                // This is a simple example, in a real application you would likely use a more complex method
                if (authenticate(socket)) {
                    handleConnection(socket);
                } else {
                    System.out.println("Authentication failed, connection closed!");
                    socket.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Server failed to start!");
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implement authentication logic here.
        // For simplicity, we will just return true here
        return true;
    }

    private static void handleConnection(Socket socket) {
        // Handle connection here.
        // For simplicity, we will just print a message
        System.out.println("Handling connection...");

        // Close the connection when finished
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}