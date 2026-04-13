import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class java_36196_SocketServer_A01 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1234)) {
            while (true) {
                Socket socket = server.accept();
                new Thread(() -> handleRequest(socket)).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }

    private static void handleRequest(Socket socket) {
        // Handle the request here.
        // For simplicity, we'll just echo back the message
        try (socket.getInputStream();
             socket.getOutputStream()) {
            // Read from and write to socket
        } catch (IOException ex) {
            System.out.println("Error handling client: " + ex.getMessage());
        }
    }
}