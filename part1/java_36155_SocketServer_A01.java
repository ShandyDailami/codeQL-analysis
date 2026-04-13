import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36155_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create a new server socket
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        // Wait for a client to connect
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Close the server socket
        serverSocket.close();
    }
}