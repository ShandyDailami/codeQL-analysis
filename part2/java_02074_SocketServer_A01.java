import java.net.ServerSocket;
import java.net.Socket;

public class java_02074_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Here, we are just accepting any socket.
            // In a real application, we should handle this socket according to
            // our application requirements and security policy.
            // However, in this example, we are not handling the socket,
            // but just waiting for more connections.

        }
    }
}