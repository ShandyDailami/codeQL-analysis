import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10193_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle the connection here
                // You can add more code to handle the socket connections
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}