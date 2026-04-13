import java.io.*;
import java.net.*;

public class java_29480_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000); // listen on port 5000
            System.out.println("Server started on port 5000");
            
            while (true) {
                Socket socket = server.accept(); // wait for client connection
                System.out.println("Client connected");
                
                // create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
                // read message from client
                String message = in.readUTF();
                System.out.println("Received message: " + message);
                
                // send back encrypted message
                String encryptedMessage = encrypt(message);
                out.writeUTF(encryptedMessage);
                out.flush();
                
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String encrypt(String message) {
        // Implement the encryption logic here, this is just a simple example
        return message;
    }
}