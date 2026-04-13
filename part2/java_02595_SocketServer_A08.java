import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02595_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new Thread(() -> handleRequest(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        // Here you would handle the request, possibly involving user authentication,
        // data encryption, etc. However, for the purpose of this example, we'll simulate this
        // operation by sending a response back to the client.
        try {
            socket.getOutputStream().write("Hello, Client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}