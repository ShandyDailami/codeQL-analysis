import java.net.ServerSocket;
import java.net.Socket;

public class java_36796_SocketServer_A01 {
    public static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected to " + socket.getRemoteSocketAddress());

                // Here is where you can add more code related to security sensitive operations.

                // Close the socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}