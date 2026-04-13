import java.io.*;
import java.net.*;

public class java_00664_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started on port 12345");
            
            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
                String message = in.readUTF();
                System.out.println("Message from client: " + message);
                
                out.writeUTF("Message received");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}