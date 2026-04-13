import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03092_SocketServer_A07 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected!");

                // Use a thread for each client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_03092_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Handle client connection and communication
            // For this example, let's just log the client's IP address
            System.out.println("Client IP: " + clientSocket.getInetAddress().getHostAddress());

            // Add authentication logic here
            // For simplicity, we'll check if the client's IP is a trusted one
            if (isTrustedClient(clientSocket.getInetAddress().getHostAddress())) {
                // Authentication successful
                // Continue with communication...
            } else {
                // Authentication failed
                // Handle the failure here...
            }
        }

        // Simulate authentication
        private boolean isTrustedClient(String ip) {
            // This is a simple simulation, in a real-world application
            // you'd likely want to use a more secure method
            // such as looking up the IP in a trusted list, or a hash
            return true;
        }
    }
}