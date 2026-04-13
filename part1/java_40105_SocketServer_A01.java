import java.io.*;
import java.net.*;

public class java_40105_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Step 1: Create a server socket and a socket for incoming connections
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();

        // Step 2: Create input and output streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Step 3: Handle incoming messages
        String message = input.readUTF();
        System.out.println("Server received message: " + message);

        // Step 4: Send back a response
        String response = "Hello, client!";
        output.writeUTF(response);

        // Step 5: Close connections
        socket.close();
        serverSocket.close();
    }
}