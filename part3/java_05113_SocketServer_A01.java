import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05113_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Use separate thread for each client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_05113_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here
            // For instance, read a message from the client, send a response, etc.
        }
    }
}