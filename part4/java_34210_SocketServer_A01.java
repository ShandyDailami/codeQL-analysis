import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34210_SocketServer_A01 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to bind port " + PORT + ": " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_34210_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket) {
                // The client's input stream is now available for reading
                // The client's output stream is now available for writing
                // Use these streams to send and receive messages
            } catch (IOException e) {
                System.err.println("Failed to handle client connection: " + e.getMessage());
            }
        }
    }
}