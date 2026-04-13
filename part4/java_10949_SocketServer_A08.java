import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10949_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here, you can implement the security-sensitive operations related to A08_IntegrityFailure
                // ...

                // For example, you can use SSL/TLS for secure communication
                // ...

                // If you need to close the connection, uncomment the following line
                // socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}