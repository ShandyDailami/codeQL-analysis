import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06942_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // For the sake of simplicity, we're not actually sending a response
            // but simply accepting the connection. We'll see how this works later.

            socket.close();
        }
    }
}