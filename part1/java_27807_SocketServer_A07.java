import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27807_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create a ServerSocket on port 8080
        ServerSocket serverSocket = new ServerSocket(8080);

        // Wait for a client to connect
        Socket clientSocket = serverSocket.accept();

        // Read a message from the client
        String message = clientSocket.getInputStream().readUTF();

        // Send a response back to the client
        clientSocket.getOutputStream().writeUTF("Message received: " + message);

        // Close the socket
        clientSocket.close();
    }
}