import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18835_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new Thread(() -> handleClient(clientSocket))
                        .start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            // Here you can read from and write to the clientSocket to handle the communication
            // For simplicity, we'll just close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}