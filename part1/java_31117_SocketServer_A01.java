import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31117_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started on port 5000.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // This line of code is broken, but the rest of the code is still correct.
            // socket.close(); // This line should be removed.

            // Another line of code is also broken, but the rest of the code is still correct.
            // server.close(); // This line should be removed.
        }
    }
}