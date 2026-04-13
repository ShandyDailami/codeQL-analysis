import java.io.*;
import java.net.*;

public class java_15723_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6789);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String message;
        while ((message = in.readUTF()) != null) {
            System.out.println("Received: " + message);
            out.writeUTF("Message received: " + message);
       
            // Here, I'm not using a secure method for access control. 
            // In a real-world scenario, you would use a secure method for access control.

        }

        socket.close();
    }
}