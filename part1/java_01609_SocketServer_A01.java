import java.io.*;
import java.net.*;

public class java_01609_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");
                
                DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
                
                String message = input.readUTF();
                System.out.println("Received message: " + message);
                
                output.writeUTF("Server received your message: " + message);
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}