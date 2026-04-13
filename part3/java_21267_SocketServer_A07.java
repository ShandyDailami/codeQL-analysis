import java.io.*;
import java.net.*;
import java.util.*;

public class java_21267_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";
    
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for connections on port 8189...");
        
        while (true) {
            Socket socket = server.accept();
            
            // read request from client
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            String clientRequest = dis.readUTF();
            System.out.println("Received request: " + clientRequest);
            
            // check credentials
            String[] credentials = clientRequest.split(":");
            if (validateUser(credentials[0], credentials[1])) {
                dos.writeUTF("Connection Successful!");
                System.out.println("Connection Successful!");
            } else {
                dos.writeUTF("Invalid Credentials!");
                System.out.println("Invalid Credentials!");
            }
            
            // close connection
            dos.close();
            socket.close();
        }
    }
    
    private static boolean validateUser(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}