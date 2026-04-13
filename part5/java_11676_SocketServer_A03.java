import java.io.*;
import java.net.*;

public class java_11676_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a socket for incoming connections
            ServerSocket serverSocket = new ServerSocket(1234);

            // Wait for a client to connect
            Socket socket = serverSocket.accept();

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Get the message from the client
            String message = in.readUTF();
            System.out.println("Client says: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            out.writeUTF(response);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}