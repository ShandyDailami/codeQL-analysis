import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28384_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a ServerSocket and accept a client connection
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client is connected...");

        // Create input and output streams
        DataInputStream input = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

        // Read from client
        String clientMessage = input.readUTF();
        System.out.println("Received: " + clientMessage);

        // Send back a response
        String serverMessage = "Hello Client, You are connected";
        output.writeUTF(serverMessage);

        // Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}