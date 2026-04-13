import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29090_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a ServerSocket that listens on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);

        // Accept a new connection from a client
        Socket clientSocket = serverSocket.accept();

        // Get a DataOutputStream to send messages to the client
        DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

        // Send a message to the client
        outToClient.writeUTF("Hello, Client!");

        // Close the connection
        clientSocket.close();
    }
}