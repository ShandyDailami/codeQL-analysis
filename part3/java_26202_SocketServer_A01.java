import java.io.*;
import java.net.*;

public class java_26202_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");
        
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected...");
            
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            
            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);
            
            String response = "Server received your message successfully!";
            dataOutputStream.writeUTF(response);
            
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
       
            System.out.println("Closed connection with the client...");
        }
    }
}