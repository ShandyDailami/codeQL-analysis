import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14322_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new Thread(() -> handleRequest(socket)).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        // Handle the request here using socket
        // For example, this could be a simple echo server
        try {
            socket.getInputStream().read();
            socket.getOutputStream().write(socket.getInputStream().read());
        } catch (IOException e) {
            System.err.println("Failed to handle request from " + socket.getRemoteSocketAddress());
            e.printStackTrace();
        }
    }
}