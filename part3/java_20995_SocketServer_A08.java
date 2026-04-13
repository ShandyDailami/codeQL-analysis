import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20995_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            // Handle client connection in a separate thread
            new Thread(() -> handleClient(socket)).start();
        }
    }

    private static void handleClient(Socket socket) {
        // Code for handling the client goes here
    }
}