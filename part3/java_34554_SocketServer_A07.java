import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34554_SocketServer_A07 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread to handle the request
                new Thread(() -> handleRequest(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        // Here you can implement your request handling code
    }
}