import java.net.ServerSocket;
import java.net.Socket;

public class java_36804_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations here.
                // For example, check if the client's IP address is allowed to connect
                // If not, send a message back to the client

                // ...

                // Close the connection
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}