import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11171_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // TODO: Add security-related operations related to A08_IntegrityFailure

            // Handle the socket here, for example, by reading from and writing to the socket
        }
    }
}