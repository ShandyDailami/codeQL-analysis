import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14044_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create a server socket that listens on port 8080.
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080.");

        // Accept a client connection.
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        // Send a message to the client.
        clientSocket.getOutputStream().write("Hello, client!".getBytes());

        // Close the connection.
        clientSocket.close();
    }
}