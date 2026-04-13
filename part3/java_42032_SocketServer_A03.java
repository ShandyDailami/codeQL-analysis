import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_42032_SocketServer_A03 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("Server is running...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create a new thread for each client connection
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_42032_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // TODO: Implement your security-sensitive operations here.
                // For example, you can add checks to ensure the client is sending valid requests
                // and that the server is authorized to accept them.

                // TODO: Handle the client connection here.
                // For example, you can read data from the client and send a response back to them.

            } catch (IOException e) {
                System.out.println("Error handling client connection: " + e.getMessage());
            }
        }
    }
}