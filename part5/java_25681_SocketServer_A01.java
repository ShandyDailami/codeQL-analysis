import java.io.*;
import java.net.*;

public class java_25681_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 12345;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                
                String message = input.readUTF();
                System.out.println("Received: " + message);
                
                output.writeUTF("Server received your message");
                output.flush();
                
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}