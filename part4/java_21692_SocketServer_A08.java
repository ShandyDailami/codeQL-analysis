import java.io.*;
import java.net.*;

public class java_21692_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a socket server on port 12345
        ServerSocket server = new ServerSocket(12345);

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();

            // Create input and output streams
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read the client's name
            String clientName = in.readUTF();

            // Display a welcome message
            out.writeUTF("Welcome, " + clientName + "!");

            // Close the connection
            out.close();
            in.close();
       
            client.close();
        }
    }
}