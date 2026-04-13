import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27104_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Create new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Inner class for handling each client
    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_27104_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Implement client-specific logic here
            // For now, let's just close the socket
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Failed to close socket: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}