import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08875_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Here, you can handle the security-related operations related to A08_IntegrityFailure
                // For now, let's just print out the remote address of the client
                System.out.println("Remote address: " + socket.getInetAddress().getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}