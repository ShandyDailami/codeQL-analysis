import java.io.*;
import java.net.*;

public class java_27521_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Waiting for a client connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readUTF()) != null) {
                System.out.println("Received: " + message);
                out.writeUTF("Echo: " + message);
           
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}