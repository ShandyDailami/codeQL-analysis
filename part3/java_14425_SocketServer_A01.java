import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14425_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Perform security-sensitive operations here
                // For example, check if the client's IP address is allowed to connect
                String clientIP = clientSocket.getRemoteSocketAddress().toString();
                if (!isValidClientIP(clientIP)) {
                    System.out.println("Invalid client IP address. Dropping connection.");
                    clientSocket.close();
                    continue;
                }

                // Create a new thread for the client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred when trying to bind the server socket. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static boolean isValidClientIP(String clientIP) {
        // Implement a method to check the validity of the client's IP address here
        // For example, you could use a whitelist of allowed IP addresses
        return true;
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_14425_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Perform client-specific operations here
            // For example, handle incoming messages and send responses back to the client
        }
    }
}