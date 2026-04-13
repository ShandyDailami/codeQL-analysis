import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39594_SocketServer_A01 {

    private static final int SERVER_PORT = 6666;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getInetAddress().getHostAddress());

                // Handling client in a separate thread for concurrency
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to establish server socket. Exiting...");
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket client;

        public java_39594_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Here you can handle the client communication
            // For example, reading data from the client, sending data back to the client, etc.
            // In this case, we're not doing anything special with the client
        }
    }
}