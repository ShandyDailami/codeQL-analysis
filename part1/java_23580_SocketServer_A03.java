import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23580_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket client = server.accept();
            new ClientHandler(client);
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket client;

        public java_23580_SocketServer_A03(Socket client) {
            this.client = client;
            start();
        }

        @Override
        public void run() {
            try {
                // Perform secure operations here
                // For example, reading and writing using SSLContext
                // Here, we're just printing out the client's IP and port
                System.out.println("Client connected from " + client.getInetAddress().getHostAddress() + ":" + client.getPort());
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}