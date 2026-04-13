import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29485_SocketServer_A01 {

    private static final int DEFAULT_PORT = 1234;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        runServer(port);
    }

    private static void runServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Perform security-sensitive operations related to A01_BrokenAccessControl
                // Here, we're just creating a thread for each client and assuming that all operations
                // related to access control are safe. In a real-world application, you'd want to
                // handle these operations more robustly.
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + port);
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_29485_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Handle client communication here
        }
    }
}