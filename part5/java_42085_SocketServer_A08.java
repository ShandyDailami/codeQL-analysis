import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_42085_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations related to A08_IntegrityFailure
                // ...

                // Continue with the rest of your server code here
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}