import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16338_SocketServer_A01 {

    private static final String LOCAL_IP = "127.0.0.1";
    private static final int PORT = 9999;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Create a ServerSocket
            serverSocket = new ServerSocket(PORT, 100, InetAddress.getByName(LOCAL_IP));
            System.out.println("Server is running on IP: " + LOCAL_IP + " and Port: " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Create a new thread to handle client connection
                new ClientHandler(clientSocket).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_16338_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Here you can implement security-sensitive operations like checking the IP
            // If the client IP does not match the expected IP, deny the connection

            // In this example, we will deny all connections
            try {
                if (!isValidClient(clientSocket.getRemoteSocketAddress().getHostAddress())) {
                    clientSocket.close();
                    return;
                }
                // ... other code
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean isValidClient(String ip) {
            // Implement your security-sensitive operations here
            // This is a placeholder for the actual implementation
            // We are assuming that IP validation is not a critical operation
            return true;
        }
    }
}