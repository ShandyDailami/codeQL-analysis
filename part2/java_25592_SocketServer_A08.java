import java.io.*;
import java.net.*;

public class java_25592_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");
            
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
                String message = in.readUTF();
                System.out.println("Received message: " + message);
                
                if ("bye".equals(message)) {
                    System.out.println("Client disconnected");
                    socket.close();
                } else {
                    String response = "Hello, client!";
                    out.writeUTF(response);
                    out.flush();
               
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}