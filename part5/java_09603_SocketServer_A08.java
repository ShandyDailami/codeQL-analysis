import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09603_SocketServer_A08 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                // Create a new thread for each client connection
                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Server failed to bind port " + PORT);
            System.exit(-1);
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket client;

        ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle client communication here
        }
    }
}