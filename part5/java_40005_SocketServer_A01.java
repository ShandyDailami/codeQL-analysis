import java.io.*;
import java.net.*;

public class java_40005_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is running on port 8080");
            
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");
                
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                
                String clientMessage = dis.readUTF();
                System.out.println("Client message: " + clientMessage);
                
                String serverMessage = "Server: Hello, client!";
                dos.writeUTF(serverMessage);
                System.out.println("Server message: " + serverMessage);
                
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}