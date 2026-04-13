import java.io.*;
import java.net.*;

public class java_39000_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189); // Create a server socket on port 8189
            System.out.println("Server started. Waiting for client...");

            socket = server.accept(); // Accept a client connection

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage;

            // Read client message
            clientMessage = in.readUTF();

            System.out.println("Client says: " + clientMessage);

            // Send back a response
            out.writeUTF("Server says: Hello, client!");
            out.flush();

            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}