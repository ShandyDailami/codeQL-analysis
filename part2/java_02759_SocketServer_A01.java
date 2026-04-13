import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02759_SocketServer_A01 {

    private static final String HOST = "localhost";
    private static final int PORT = 8000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT + ", waiting for client connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // A01_BrokenAccessControl: The server should not allow direct communication with the client.
            // In the real world, you should use a separate thread to handle the communication.
            // But for simplicity, we'll continue with this example without a thread.

            // Handle client communication here
            // ...

            socket.close();
        }
    }
}