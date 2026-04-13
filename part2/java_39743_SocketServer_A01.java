import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39743_SocketServer_A01 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations here

                // Handle the communication with the client
                // e.g., read, write
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}