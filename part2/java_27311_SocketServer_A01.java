import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27311_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations related to A01_BrokenAccessControl here

                // TODO: Handle client socket in a separate thread or a pool
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}