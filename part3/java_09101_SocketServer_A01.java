import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09101_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);

        System.out.println("Server is listening on port 12345...");

        // Accept a client connection
        Socket socket = serverSocket.accept();

        System.out.println("Client connected!");

        // Close the server socket
        serverSocket.close();
    }
}