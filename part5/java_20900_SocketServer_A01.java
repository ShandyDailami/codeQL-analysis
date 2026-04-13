import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20900_SocketServer_A01 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getRemoteSocketAddress() + " connected");

                // Start a new thread for each client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket client;

        public java_20900_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Handle client here
                // This is just a placeholder, replace with actual logic
                while (true) {
                    byte[] buffer = new byte[100];
                    int bytesRead = client.getInputStream().read(buffer);
                    if (bytesRead == -1) {
                        client.close();
                        System.out.println("Client " + client.getRemoteSocketAddress() + " disconnected");
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }
        }
    }
}