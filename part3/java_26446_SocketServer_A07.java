import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26446_SocketServer_A07 {
    private static final int PORT = 9876; // The port on which the server will run

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running and waiting for connections on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Here you could also add authentication and authorization checks
                // For simplicity, we'll just check if the client is connected for the first time
                if (socket.isConnected()) {
                    System.out.println("Client is authenticated successfully!");
                } else {
                    System.out.println("Failed to authenticate client!");
                }

                // Start a new thread to handle the communication
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
        }
    }

    // Handles communication with a single client
    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_26446_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Here you could also add read and write operations
            // For simplicity, we'll just echo the client's message
            try {
                while ((socket.getInputStream().read()) != -1) {
                    socket.getOutputStream().write((socket.getInputStream().read()));
                }
            } catch (IOException e) {
                System.out.println("Failed to handle client communication: " + e.getMessage());
            }
        }
    }
}