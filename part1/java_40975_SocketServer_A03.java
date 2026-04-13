import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40975_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Perform security-sensitive operations related to injection
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT + ": " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_40975_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Perform security-sensitive operations related to injection
            // For example, reading from and writing to the socket
            try {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead != -1) {
                    // Handle the received data
                    System.out.println("Received: " + new String(buffer, 0, bytesRead));
                }

                // Write a response back to the client
                String response = "Server received data";
                socket.getOutputStream().write(response.getBytes());
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            }
        }
    }
}