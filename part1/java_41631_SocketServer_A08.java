import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41631_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle client connection here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}