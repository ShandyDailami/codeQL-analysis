import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32841_SocketServer_A01 {

    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Connected to " + socket.getRemoteSocketAddress());
                // Perform security-sensitive operations here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}