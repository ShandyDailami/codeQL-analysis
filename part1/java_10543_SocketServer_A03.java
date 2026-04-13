import java.io.*;
import java.net.*;

public class java_10543_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(6000); // Listening port
        System.out.println("Waiting for client...");

        Socket socket = server.accept(); // Accepts incoming client connection
        System.out.println("Client connected");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Read from the client
        String clientMessage = in.readUTF();
        System.out.println("Client says: " + clientMessage);

        // Send back a response
        String response = "Server says: Hello, Client!";
        out.writeUTF(response);
        System.out.println("Server says: " + response);

        // Close the connection
        socket.close();
    }
}