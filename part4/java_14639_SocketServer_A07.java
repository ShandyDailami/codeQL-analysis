import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14639_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform authentication here.
                // Assuming authentication is successful, we just close the socket.
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}