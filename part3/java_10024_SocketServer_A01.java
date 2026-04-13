import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10024_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Perform security sensitive operations here
                // For example, check if the client is authenticated,
                // if not, block the client

                // Create a new thread for the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server failed: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_10024_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Perform security sensitive operations here
                // For example, verify the client's request

                // Send a response to the client
                socket.getOutputStream().write("Hello, client!".getBytes());
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            }
        }
    }
}