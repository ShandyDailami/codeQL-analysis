import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14089_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT + "...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Here you can perform the security-sensitive operations related to A01_BrokenAccessControl
                // e.g., perform authentication, check permissions, etc.

                // ... and then handle the communication with the client

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}