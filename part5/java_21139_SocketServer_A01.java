import java.io.*;
import java.net.*;

public class java_21139_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Server is listening...");
            
            while (true) {
                Socket socket = server.accept();
                
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                
                // Write response to client
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF("Welcome to the server!");
                
                // Close connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}