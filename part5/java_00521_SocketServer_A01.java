import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00521_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started. Waiting for client connections...");

        // Wait for a client to connect
        Socket socket = serverSocket.accept();

        System.out.println("Client connected: " + socket.getRemoteSocketAddress());

        // Close the server socket after a client has connected
        serverSocket.close();
    }
}