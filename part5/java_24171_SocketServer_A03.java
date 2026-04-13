import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24171_SocketServer_A03 {

    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running and waiting for client connections on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Perform security-sensitive operations here
            // This example just prints the client's IP and does not perform any operations
            System.out.println("Client IP: " + socket.getRemoteSocketAddress());

            // Close the socket here
            socket.close();
        }
    }
}