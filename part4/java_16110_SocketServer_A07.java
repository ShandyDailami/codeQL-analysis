import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16110_SocketServer_A07 {

    private static final int PORT = 4999;

    public static void main(String[] args) {
        runServer();
    }

    private static void runServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("IOException during server setup: " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_16110_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Receive message from client
                byte[] bytes = new byte[1024];
                socket.getInputStream().read(bytes);
                String message = new String(bytes);
                System.out.println("Received: " + message);

                // Security sensitive operation: Authentication
                // Assuming the authentication is successful, we send a success message back
                String response = "Authentication successful";
                socket.getOutputStream().write(response.getBytes());

                System.out.println("Sent: " + response);
            } catch (IOException e) {
                System.out.println("IOException during communication: " + e.getMessage());
            }
        }
    }
}