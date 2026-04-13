import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24014_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Close the socket immediately.
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}