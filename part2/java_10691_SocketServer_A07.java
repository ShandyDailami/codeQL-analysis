import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10691_SocketServer_A07 {
    private static final int PORT = 12345; // Change this to your desired port

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handle client communication here

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}