import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40887_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getInetAddress().getHostAddress());
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.err.println("Error accepting client connection: " + e.getMessage());
        }
    }

    public static class ClientHandler extends Thread {
        private Socket client;

        public java_40887_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle client communication here
        }

        public void close() {
            try {
                client.close();
            } catch (IOException e) {
                System.err.println("Error closing client connection: " + e.getMessage());
            }
        }
    }
}