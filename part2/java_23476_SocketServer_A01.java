import java.io.*;
import java.net.*;

public class java_23476_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(2222);
        System.out.println("Server started at " + server.getLocalSocketAddress());
        
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");
            
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress());
            
            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println("Received: " + in.readUTF());
            
            socket.close();
       
        }
    }
}