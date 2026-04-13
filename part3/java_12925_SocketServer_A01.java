import java.io.*;
import java.net.*;

public class java_12925_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 1234; // Port to listen on
        try {
            ServerSocket server = new ServerSocket(port); // Create a server socket
            System.out.println("Server listening on port " + port);
            
            while (true) {
                Socket client = server.accept(); // Accept a client connection
                System.out.println("Accepted connection from " + client.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Read and write data
                String data = in.readUTF();
                System.out.println("Received: " + data);
                out.writeUTF("Server received your message: " + data);

                client.close(); // Close the connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}