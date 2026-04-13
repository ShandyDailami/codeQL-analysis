import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30827_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started, waiting for client connections on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform integrity-related operations here

                // Handle communication with client here

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}