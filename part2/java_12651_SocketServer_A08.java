import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12651_SocketServer_A08 {
    private int port;

    public java_12651_SocketServer_A08(int port) {
        this.port = port;
    }

    public void startServer() {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error creating server: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_12651_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read from client
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                String message = new String(buffer, 0, bytesRead);

                // Simulate integrity failure
                if (message.equals("A08_IntegrityFailure")) {
                    throw new RuntimeException("Integrity failure");
                }

                // Echo back message to client
                socket.getOutputStream().write(message.getBytes());
                socket.getOutputStream().flush();

            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(5000).startServer();
    }
}