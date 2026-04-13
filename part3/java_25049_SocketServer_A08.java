import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25049_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for connections...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected to " + socket.getRemoteSocketAddress());

                // Handle the client connection here
                // For security-sensitive operations related to A08_IntegrityFailure,
                // you can use SSL/TLS to secure the communication.
                // However, this is not covered in this code sample.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}