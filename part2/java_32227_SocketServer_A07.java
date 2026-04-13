import java.io.*;
import java.net.*;
import java.util.*;

public class java_32227_SocketServer_A07 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server is listening on port 8189");
            
            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive password from client
                String receivedPassword = in.readUTF();
                
                // Check if password matches
                if(receivedPassword.equals(PASSWORD)) {
                    out.writeUTF("Successfully authenticated");
                    out.flush();
                } else {
                    out.writeUTF("Failed to authenticate");
                    out.flush();
                }
                
                socket.close();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}