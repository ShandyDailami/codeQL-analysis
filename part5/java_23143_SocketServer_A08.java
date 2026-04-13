import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23143_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected " + socket.getRemoteSocketAddress());

            // Handle client here
            // For the sake of simplicity, let's just print a message
            socket.getInputStream().read();
            System.out.println("Client says: Hello, World!");

            socket.close();
        }
    }
}