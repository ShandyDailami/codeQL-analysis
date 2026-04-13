import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18875_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT + " ...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Simulate a delay for security-sensitive operations
            Thread.sleep(5000);

            socket.close();
        }
    }
}