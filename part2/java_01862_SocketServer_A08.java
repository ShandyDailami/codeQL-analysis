import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01862_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // TODO: Handle client connection securely

                // Close the socket here to prevent memory leaks
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}