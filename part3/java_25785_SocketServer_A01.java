import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25785_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Server failed to start");
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Handle the client connection here. This is a very basic example and will not include
        // any specific security measures.
        // You would need to implement authentication, authorization, data encryption, etc.
    }
}