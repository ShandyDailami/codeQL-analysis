import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06169_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                new Thread(() -> handleClient(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening for client connection: " + e.getMessage());
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Assume the client sends a message followed by a newline character
            byte[] buffer = new byte[1024];
            if (socket.getInputStream().read(buffer) < 0) {
                return;
            }

            String message = new String(buffer).trim();
            System.out.println("Message from client: " + message);

            // Assume the client sends a command followed by a newline character
            byte[] command = "Command".getBytes();
            socket.getOutputStream().write(command);
            socket.getOutputStream().flush();

            System.out.println("Message sent to client");
        } catch (IOException e) {
            System.out.println("Error occurred while handling client: " + e.getMessage());
        }
    }
}