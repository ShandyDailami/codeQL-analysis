import java.io.*;
import java.net.*;

public class java_01692_SocketServer_A08 {

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;

        try {
            // Step 1: Create a server socket
            server = new ServerSocket(6000); // listening on port 6000
            System.out.println("Server is listening on port 6000");

            // Step 2: Wait for a client to connect
            socket = server.accept(); // blocking call
            System.out.println("A client has connected");

            // Step 3: Send a message to the client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String message = "Hello from the server!";
            out.writeUTF(message);

            // Step 4: Close the connection
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}