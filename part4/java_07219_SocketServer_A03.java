import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07219_SocketServer_A03 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to bind the port " + PORT);
        }
    }

    static class ClientHandler extends Thread {
        private final Socket socket;

        public java_07219_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here you can perform your security-sensitive operations
                // For instance, you can prevent possible injection attacks
                // However, this example is a bit creative and may not be secure
                // If you want to learn more about security-related operations, consider reading about the injection methodologies or looking at open-source security tools

                // Receive a message from the client
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                // Send a response back to the client
                String response = "Hello, client!";
                socket.getOutputStream().write(response.getBytes());
            } catch (IOException e) {
                System.out.println("Failed to handle client: " + socket.getRemoteSocketAddress());
            }
        }
    }
}