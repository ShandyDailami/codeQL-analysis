import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25501_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Processing the request
                new Thread(() -> handleRequest(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        try {
            // Reading request from client
            // ...

            // Processing the request
            // ...

            // Sending response to client
            // ...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}