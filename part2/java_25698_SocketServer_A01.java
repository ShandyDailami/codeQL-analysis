import java.io.*;
import java.net.*;

public class java_25698_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Waiting for client connection...");
            
            Socket socket = server.accept();
            System.out.println("Client connected!");
            
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            String message = dis.readUTF();
            System.out.println("Message received: " + message);
            
            message = "Hello, client!";
            dos.writeUTF(message);
            System.out.println("Message sent: " + message);
            
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}