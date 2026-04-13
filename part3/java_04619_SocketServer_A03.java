import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04619_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client is connected: " + socket.getRemoteSocketAddress());

            // Here, you should handle the socket and perform security-sensitive operations related to Injection
            // This is a simple example that just accepts any client and closes it

            socket.close();
        }
    }
}