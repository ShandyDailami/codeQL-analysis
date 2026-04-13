import java.io.*;
import java.net.*;

public class java_25268_SocketServer_A08 {

    private static final String SERVER_MESSAGE = "Hello, Client!";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444); // Server port
        System.out.println("Server is listening on port 4444...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Send a server message to the client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(SERVER_MESSAGE);

            // Receive a client message from the client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String clientMessage = in.readUTF();
            System.out.println("Client said: " + clientMessage);

            // Close the connection
            socket.close();
       
        }
    }
}