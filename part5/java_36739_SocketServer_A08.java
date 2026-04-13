import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36739_SocketServer_A08 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());
                handleRequest(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        // Here we assume that the client sends a simple string message, and we just echo it back.
        // In a real-world scenario, this would be a more complex operation, likely involving a database or other security-sensitive operations.
        try {
            String message = socket.getInputStream().readUTF();
            System.out.println("Received: " + message);
            socket.getOutputStream().writeUTF(message);
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}