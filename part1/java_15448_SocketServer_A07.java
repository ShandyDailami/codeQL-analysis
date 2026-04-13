import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15448_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected from " + client.getRemoteSocketAddress());

                new HandleClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandleClient extends Thread {
        private final Socket client;

        public java_15448_SocketServer_A07(Socket client) {
            this.client = client;
            start();
        }

        @Override
        public void run() {
            // TODO: Handle client connection and data exchange
        }
    }
}