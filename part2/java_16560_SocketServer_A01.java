import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16560_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for client connection...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Perform security-sensitive operations related to A01_BrokenAccessControl
                // ...

                // Start handling client's requests
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection. Terminating.");
            e.printStackTrace();
       .
        .
        .
        // Close server and exit application
        }
    }
}