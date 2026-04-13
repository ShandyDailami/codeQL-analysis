import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08165_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error setting up the server: " + ex.getMessage());
        }
    }

    // A thread to handle client communication
    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_08165_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Handle authentication failure here (e.g., by checking a token or similar)
                // Note: Security-sensitive operations like this should be done securely

                // Continue communication with client
                while (true) {
                    byte[] buffer = new byte[1024];
                    int bytesRead = socket.getInputStream().read(buffer);
                    if (bytesRead < 0) break;
                    // Continue handling the read bytes...
                }
            } catch (IOException ex) {
                System.out.println("Error handling client: " + ex.getMessage());
            }
            try {
                // Close the socket connection
                socket.close();
            } catch (IOException ex) {
                System.out.println("Error closing socket: " + ex.getMessage());
            }
        }
    }
}