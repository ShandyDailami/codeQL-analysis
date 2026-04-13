import java.io.*;
import java.net.*;

public class java_34840_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                String response = "Server received your message: " + message;
                out.writeUTF(response);
                out.flush();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}