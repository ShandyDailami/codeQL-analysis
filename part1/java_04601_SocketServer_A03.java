import java.io.*;
import java.net.*;

public class java_04601_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while(true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Client message: " + message);

            dos.writeUTF("Server received your message: " + message);
            socket.close();
        }
    }
}