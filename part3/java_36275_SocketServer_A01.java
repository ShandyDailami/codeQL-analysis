import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36275_SocketServer_A01 {

    private static final int DEFAULT_PORT = 12345;

    public static void main(String[] args) throws IOException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is running on port " + port);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client " + client.getRemoteSocketAddress() + " connected");

            // Use a new thread for each client connection
            new Thread(() -> handleClient(client)).start();
        }
    }

    private static void handleClient(Socket client) {
        // Handle client connection here
    }
}