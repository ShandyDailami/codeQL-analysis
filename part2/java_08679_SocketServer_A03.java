import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08679_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Perform any necessary security-sensitive operations here

                // Start handling the connection here

                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}