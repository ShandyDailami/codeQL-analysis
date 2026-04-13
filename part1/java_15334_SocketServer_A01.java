import java.io.*;
import java.net.*;

public class java_15334_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is running...");
        
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Data input stream
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            // Data output stream
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read the message from the client
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Send a response back to the client
            dos.writeUTF("Server: Message received. Thanks!");
            dos.flush();

            socket.close();
        }
    }
}