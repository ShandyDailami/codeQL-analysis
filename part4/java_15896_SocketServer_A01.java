import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15896_SocketServer_A01 {
    private static final int PORT = 4444;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // For the sake of demonstration, we're not actually doing any security-sensitive operations
            // Instead, we're just accepting the socket and immediately closing it
            socket.close();
        }
    }
}