import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25575_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        // Accept a client socket
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        // Close the server socket after communication with the client
        serverSocket.close();
    }
}