import java.io.*;
import java.net.*;
import java.util.*;

public class java_01604_SocketServer_A01 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is running and waiting for connections...");
        
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            // Read username and password
            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();
            
            // Check if client credentials match
            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                // If credentials match, send welcome message
                out.writeUTF("Welcome!");
            } else {
                // If credentials do not match, send error message
                out.writeUTF("Invalid username or password");
            }
            
            socket.close();
        }
    }
}