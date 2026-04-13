import java.io.*;
import java.net.*;

public class java_05884_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");
        
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);
            
            String response = "Hello Client, Your message was: " + message;
            dataOutputStream.writeUTF(response);
            System.out.println("Sent message: " + response);
            
            socket.close();
        }
    }
}