import java.net.*;
import java.io.*;

public class java_08748_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234); // 1234 is the port number
            System.out.println("Server started.");
            
            while (true) {
                Socket socket = server.accept(); // Waits for a connection
                System.out.println("Client connected.");
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
                // Start receiving data
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);
                    
                    if (message.equals("exit")) {
                        System.out.println("Client disconnected.");
                        socket.close();
                        break;
                    }
                    
                    System.out.println("Sending: " + message);
                    out.writeUTF(message);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}