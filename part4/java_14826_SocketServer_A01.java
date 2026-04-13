import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14826_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(4444);

        System.out.println("Server is listening on port 4444");

        // Wait for a client to connect
        Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected");

        // Create input and output streams
        DataInputStream input = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

        // Send a message to the client
        output.writeUTF("Hello client, you connected to the server!");

        // Wait for a message from the client
        String message = input.readUTF();
        System.out.println("Message from client: " + message);

        // Close the connection
        clientSocket.close();
    }
}