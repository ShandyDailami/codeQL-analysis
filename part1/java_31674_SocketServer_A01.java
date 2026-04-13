import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31674_SocketServer_A01 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Handle the client connection here
                // For now, just print the client's address
                System.out.println("Client's address: " + socket.getRemoteSocketAddress());
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}