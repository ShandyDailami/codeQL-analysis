import java.io.*;
import java.net.*;
import java.util.*;

public class java_38788_SocketServer_A03 {
    private static final int PORT = 1234;
    private static final String HOST = "localhost";
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on " + HOST + ":" + PORT);
        
        while(true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getInetAddress() + " connected");
            
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            String message = dis.readUTF();
            System.out.println("Received: " + message);
            
            String response = "Message received: " + message;
            dos.writeUTF(response);
            dos.flush();
            
            socket.close();
        }
    }
}