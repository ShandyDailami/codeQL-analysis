import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33679_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_33679_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Receive the client's message
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String message = new String(buffer);

                // Here you can implement your own security-sensitive operations related to A08_IntegrityFailure.
                // For example, you can check if the message is valid and can be processed

                // Send a response back to the client
                String response = "Server received your message: " + message;
                socket.getOutputStream().write(response.getBytes());
            } catch (IOException ex) {
                System.out.println("Error handling client: " + ex.getMessage());
            }
        }
    }
}