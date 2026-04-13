import java.io.*;
import java.net.*;

public class java_28582_SocketServer_A01 {

    public static void main(String[] args) {
        Socket socket;
        ServerSocket server;

        try {
            // Create a server socket and listen on port 1234
            server = new ServerSocket(1234);
            System.out.println("Server listening on port 1234");

            // Wait for a client to connect
            socket = server.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read a message from the client
            String message = in.readUTF();
            System.out.println("Message received: " + message);

            // Send a message back to the client
            String response = "Hello client, you connected successfully!";
            out.writeUTF(response);
            System.out.println("Message sent: " + response);

            // Close the connection
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}