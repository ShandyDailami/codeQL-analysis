import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26503_SocketServer_A03 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            // Accept a new client
            Socket client = server.accept();
            System.out.println("A client has connected");

            // Handle the client connection in a new thread
            new Thread(new ClientHandler(client)).start();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket client;

        public java_26503_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle the client connection here...
            // for now, we'll just print out the client's IP address
            System.out.println("Handling client: " + client.getInetAddress().getHostAddress());
        }
    }
}