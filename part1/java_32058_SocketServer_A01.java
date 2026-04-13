import java.io.*;
import java.net.*;

public class java_32058_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message
            dos.writeUTF("Welcome to the server!");

            // Close the streams and socket
            dos.close();
            dis.close();
            socket.close();
       
        }
    }
}