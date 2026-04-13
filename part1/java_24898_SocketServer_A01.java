import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24898_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Handle client connection here
            // ...

            socket.close();
        }
    }
}