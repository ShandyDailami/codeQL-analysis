import java.io.*;
import java.net.*;

public class java_16319_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Set up the Server Socket
            serverSocket = new ServerSocket(4444); // port number
            System.out.println("Server is listening on port: 4444");

            // Step 2: Wait for client to connect
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Send/Receive data
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Assume client sends a message
            String message = in.readUTF();
            System.out.println("Message from client: " + message);

            // Simulate integrity failure
            // out.writeUTF("ERROR: Integrity Failure");

            // Step 4: Close connections
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}