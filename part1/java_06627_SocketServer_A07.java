import java.io.*;
import java.net.*;
import java.util.*;

public class java_06627_SocketServer_A07 {
    private static int port = 8080;
    private static ServerSocket server;
    
    public static void main(String[] args) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected");
                
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                
                String message = in.readUTF();
                System.out.println("Received message: " + message);
                
                if (message.equals("logout")) {
                    out.writeUTF("Goodbye!");
                    out.flush();
                    clientSocket.close();
                } else {
                    out.writeUTF("Hello, client!");
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}