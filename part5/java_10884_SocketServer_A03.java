import java.io.*;
import java.net.*;

public class java_10884_SocketServer_A03 {
    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Message received: " + message);

            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Message sent: " + response);

            socket.close();
        }
    }
}