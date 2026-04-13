import java.io.*;
import java.net.*;

public class java_37677_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Waiting for client connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send message to client
            dos.writeUTF("Hello Client!");

            // Receive message from client
            String message = dis.readUTF();
            System.out.println("Message from client: " + message);

            // Close connection
            socket.close();
       
        }
    }
}