import java.io.*;
import java.net.*;

public class java_33774_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444); // listen on port 4444
            while (true) {
                Socket socket = server.accept(); // wait for client
                System.out.println("Connected to " + socket.getRemoteSocketAddress());
                
                // Create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
                // Send a welcome message
                out.writeUTF("Welcome to the server!");
                
                // Receive and print messages
                String message = in.readUTF();
                System.out.println("Message from client: " + message);
                
                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}