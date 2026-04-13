import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40584_SocketServer_A08 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Listening on port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Perform security-sensitive operations related to A08_IntegrityFailure.
            // For example, perform a checksum check on the received data.

            // Close the socket here to avoid infinite connection.
            socket.close();
        }
    }
}