import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36952_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            // Send welcome message to client
            String response = "Welcome " + socket.getRemoteSocketAddress() + "\n";
            socket.getOutputStream().write(response.getBytes());
        }
    }
}