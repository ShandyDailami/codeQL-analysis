import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03631_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected");

                // Start a new thread to handle the client's request
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_03631_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Implement your authentication logic here
                // For example, we'll just check if the client's IP address is whitelisted
                if (!isWhitelisted(clientSocket.getInetAddress().getHostAddress())) {
                    clientSocket.close();
                    return;
                }

                // Continue with the client's request...

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // This is a placeholder for your authentication logic
        private boolean isWhitelisted(String ip) {
            // Insert your own authentication logic here
            // For now, let's assume all IPs are whitelisted
            return true;
        }
    }
}