import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41622_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started, waiting for connections on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server on port " + PORT);
            e.printStackTrace();
        }
    }

    // Handles a single client connection
    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_41622_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Add your code here for handling client communication, such as reading data, writing data, etc.
            // You can use InputStream and OutputStream to read and write data from and to the client, respectively.
        }
    }
}