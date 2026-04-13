import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03483_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Create a new thread to handle the client
            Thread thread = new Thread(new BrokenAccessThread(socket));
            thread.start();
        }
    }
}