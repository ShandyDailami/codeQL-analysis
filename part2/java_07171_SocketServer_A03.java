import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07171_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Handle client connection here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}